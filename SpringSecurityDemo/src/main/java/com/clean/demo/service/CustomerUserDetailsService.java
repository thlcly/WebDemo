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

            // 搜索数据库以匹配用户登录名.
            // 我们可以通过dao使用JDBC来访问数据库
            // 在这里使用List模仿数据库
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
     * 获得访问角色权限
     *
     * @param access
     * @return
     */
    public Collection<GrantedAuthority> getAuthorities(Integer access) {

        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

        // 所有的用户默认拥有ROLE_USER权限
        authList.add(new GrantedAuthorityImpl("ROLE_USER"));

        // 如果参数access为1.则拥有ROLE_ADMIN权限
        if (access.compareTo(1) == 0) {
            authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        }
        return authList;
    }
}
