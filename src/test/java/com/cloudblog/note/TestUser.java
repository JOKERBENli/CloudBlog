package com.cloudblog.note;


import com.cloudblog.note.dao.UserDao;
import com.cloudblog.note.po.User;
import org.junit.Test;

public class TestUser {
    @Test
    public void testQueryUserByName(){
        UserDao userDao = new UserDao();
        User user = userDao.queryUserByName("admin");
        System.out.println(user.getUpwd());
    }
}
