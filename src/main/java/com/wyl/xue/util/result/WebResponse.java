package com.wyl.xue.util.result;

/**
 * @ClassName: WebResponse
 * @Function: 返回结果工具
 * @Date: 2020/4/12 19:58
 * @author wangyl
 * @version V1.0
 */
public enum WebResponse {
    WebResponse;

    public <T> WebResult<T> ok() {
        return new WebResult<T>(ResultCode.SUCCEED);
    }

    public <T> WebResult<T> ok(ResultCode resultCode, T data) {
        return new WebResult<T>(ResultCode.SUCCEED);
    }

    public <T> WebResult<T> ok(T data) {
        return new WebResult<T>(ResultCode.SUCCEED, data);
    }

    public <T> WebResult<T> error() {
        return new WebResult<T>(ResultCode.FAILED);
    }

    public <T> WebResult<T> error(T data) {
        return new WebResult<T>(ResultCode.FAILED, data);
    }

    public <T> WebResult<T> error(ResultCode resultCode, T data) {
        return new WebResult<T>(resultCode, data);
    }

    public <T> WebResult<T> error(Integer code, String msg) {
        return new WebResult<T>(code, msg);
    }

    private <T> WebResult<T> WebResponse(Integer code, String msg, T data) {
        return new WebResult<T>(code, msg, data);
    }

    private <T> WebResult<T> WebResponse(Integer code, String msg) {
        return new WebResult<T>(code, msg);
    }
}
