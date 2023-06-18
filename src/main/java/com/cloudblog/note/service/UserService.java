package com.cloudblog.note.service;


import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.cloudblog.note.dao.UserDao;
import com.cloudblog.note.po.User;
import com.cloudblog.note.result.ResultInfo;


public class UserService {
    private UserDao userDao = new UserDao();

    public ResultInfo<User> userLogin(String userName, String userPwd){
        ResultInfo<User> resultInfo = new ResultInfo<>();

        //判断参数是否为空
        if(StrUtil.isBlank(userName) || StrUtil.isBlank(userPwd)){
            //如果返回前台用户名和密码为空，设置ResultInfo对象状态码和提示信息
            resultInfo.setCode(0);
            resultInfo.setMsg("用户姓名或密码不能为空！");
            return resultInfo;
        }

        //如果不为空，通过用户名查询用户对象
        User user = userDao.queryUserByName(userName);

        //判断后台用户对象是否为空
        if(user == null){
            resultInfo.setCode(0);
            resultInfo.setMsg("该用户不存在！");
            return resultInfo;
        }
        //将数据库查询到的用户对象的密码和前台密码比较
        // md5加密
        userPwd = DigestUtil.md5Hex(userPwd);

        if(!userPwd.equals(user.getUpwd())){
            resultInfo.setCode(0);
            resultInfo.setMsg("用户密码不正确!");
            return resultInfo;
        }

        resultInfo.setCode(1);
        resultInfo.setResult(user);
        return resultInfo;
    }
}
