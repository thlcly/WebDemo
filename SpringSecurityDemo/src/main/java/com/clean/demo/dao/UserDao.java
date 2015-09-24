package com.clean.demo.dao;

import com.clean.demo.pojo.DbUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonghui on 2015/9/25.
 */
@Repository
public class UserDao {

    public DbUser getDatabase(String username) {

        List<DbUser> users = internalDatabase();

        for (DbUser dbUser : users) {
            if (dbUser.getUsername().equals(username) == true) {
                return dbUser;
            }
        }
        throw new RuntimeException("User does not exist!");

    }

    /**
     * ��ʼ������
     */

    /**
     * ģ�����ݿ�,�൱���ǻ�ȡ���е��û�����
     * */
    private List<DbUser> internalDatabase() {

        List<DbUser> users = new ArrayList<DbUser>();
        DbUser user = null;

        user = new DbUser();
        user.setUsername("admin");

        // "admin"����MD5���ܺ�
        user.setPassword("admin");
        user.setAccess(1);

        users.add(user);

        user = new DbUser();
        user.setUsername("user");

        // "user"����MD5���ܺ�
        user.setPassword("user");
        user.setAccess(2);

        users.add(user);

        return users;

    }
}
