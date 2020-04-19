package com.wyl.xue.util.result;

public enum ResultCode {
    SUCCEED(200, "成功"),
    FAILED(-1, "系统异常"),
    DATAINSERTERROR(10000, "数据库数据插入失败"),
    HAVERESOURCES(10001,"该节点有相关资源无法删除"),
    USERNAMEORPASSWORDERROR(10002,"用户名或密码错误"),
    PASSWORDPASTDUE(10003,"密码已过期"),
    ACCOUNTISDISABLED(10004,"账户已被禁用"),
    ACCOUNTOVERDUE(10005,"帐号已过期"),
    ACCOUNTLOCKED(10006,"账户已被锁定");


    public Integer code;
    public String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
