package com.cloudblog.note.result;
/**
 * 封装返回结果的类
 * 成功=1，失败=0
 * 提示信息
 * 返回的对象（字符串、javabean、集合、Map等）
 * */
public class ResultInfo<T> {
    private Integer code;//状态码
    private String msg;//提示
    private T result;//返回对象

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
