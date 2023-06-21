package com.cloudblog.note.dao;

import com.cloudblog.note.po.User;

import java.util.ArrayList;
import java.util.List;

public class registerDao {
    public User insertUser(String userName) {
        // 1.定义sql语句
        String sql = "select * from tb_user where uname = ?";

        // 2.设置参数集合
        List<Object> params = new ArrayList<>();
        params.add(userName);

        // 3.调用BaseDao类的查询方法
        User user = (User) BaseDao.queryRow(sql, params, User.class);

        return user;
    }





}
