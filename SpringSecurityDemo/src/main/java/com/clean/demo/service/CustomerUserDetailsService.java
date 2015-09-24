package com.clean.demo.service;

import com.clean.demo.dao.UserDao;
import com.clean.demo.pojo.DbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by tonghui on 2015/9/24.
 */
public class CustomerUserDetailsService implements UserDetailsService{

    @Autowired
    private UserDao userDAO;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = null;

        try {

            // �������ݿ���ƥ���û���¼��.
            // ���ǿ���ͨ��daoʹ��JDBC���������ݿ�
            // ������ʹ��Listģ�����ݿ�
            DbUser dbUser = userDAO.getDatabase(username);

            // Populate the Spring User object with details from the dbUser
            // Here we just pass the username, password, and access level
            // getAuthorities() will translate the access level to the correct
            // role type

            user = new User(dbUser.getUsername(), dbUser.getPassword()
                    .toLowerCase(), true, true, true, true,
                    getAuthorities(dbUser.getAccess()));

        } catch (Exception e) {
            throw new UsernameNotFoundException("Error in retrieving user");
        }

        return user;
    }


    /**
     * ��÷��ʽ�ɫȨ��
     *
     * @param access
     * @return
     */
    public Collection<GrantedAuthority> getAuthorities(Integer access) {

        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

        // ���е��û�Ĭ��ӵ��ROLE_USERȨ��
        authList.add(new GrantedAuthorityImpl("ROLE_USER"));

        // �������accessΪ1.��ӵ��ROLE_ADMINȨ��
        if (access.compareTo(1) == 0) {
            authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        }
        return authList;
    }
}
