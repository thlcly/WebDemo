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
     * 初始化数据
     */

    /**
     * 模拟数据库,相当于是获取所有的用户对象
     * */
    private List<DbUser> internalDatabase() {

        List<DbUser> users = new ArrayList<DbUser>();
        DbUser user = null;

        user = new DbUser();
        user.setUsername("admin");

        // "admin"经过MD5加密后
        user.setPassword("admin");
        user.setAccess(1);

        users.add(user);

        user = new DbUser();
        user.setUsername("user");

        // "user"经过MD5加密后
        user.setPassword("user");
        user.setAccess(2);

        users.add(user);

        return users;

    }
}
