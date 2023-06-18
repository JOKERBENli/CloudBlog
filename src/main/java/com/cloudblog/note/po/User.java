package com.cloudblog.note.po;

//使用lombok编写get和set方法，需要设置插件
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter

public class User {
    private Integer userId; //用户Id
    private String uname; //用户名
    private String upwd; //用户密码
    private String nick;//用户昵称
    private String head;//用户头像
    private String mood;//用户签名

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
