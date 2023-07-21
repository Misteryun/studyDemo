package com.example.testdemo.common;

public enum ResCode {

    /// <summary>
    /// 成功
    /// </summary>
    success("success"),
    /// <summary>
    /// 失败
    /// </summary>
    fail("fail"),
    /// <summary>
    /// 非法
    /// </summary>
    invalid("401"),
    /// <summary>
    /// 未登录
    /// </summary>
    unlogin("402"),
    /// <summary>
    /// 非法用户
    /// </summary>
    invaliduser("403"),
    /// <summary>
    /// 非法操作
    /// </summary>
    invalidaction("404"),
    /// <summary>
    /// 非法数据
    /// </summary>
    invaliddata("405"),
    /// <summary>
    /// 非法时间戳
    /// </summary>
    invalidtimestamp("406"),
    /// <summary>
    /// 非法签名
    /// </summary>
    invalidsignature("407"),
    /// <summary>
    /// 非法IP
    /// </summary>
    invalidip("408"),
    /// <summary>
    /// 传入的action version与服务器的版本不一致
    /// </summary>
    invalidactionversion("409"),
    /// <summary>
    /// 非法(其它)
    /// </summary>
    invalidelse("-1"),
    /// <summary>
    /// 异常
    /// </summary>
    exception("500");


    // 定义一个 private 修饰的实例变量
    private String resCode;

    ResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }
}
