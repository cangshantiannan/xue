package com.wyl.xue.util.result;

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

    private <T> WebResult<T> WebResponse(Integer code, String msg, T data) {
        return new WebResult<T>(code, msg, data);
    }

    private <T> WebResult<T> WebResponse(Integer code, String msg) {
        return new WebResult<T>(code, msg);
    }
}
