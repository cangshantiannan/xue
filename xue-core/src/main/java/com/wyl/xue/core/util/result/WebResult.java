package com.wyl.xue.core.util.result;

import lombok.Data;

/**
 * @ClassName: WebResult
 * @Function: 返回对象
 * @Date: 2020/3/27 10:49
 * @author wangyl
 * @version V1.0
 */
@Data
public class WebResult<T> {
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 描述信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    public WebResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public WebResult(ResultCode resultCode) {
        this(resultCode, null);
    }

    public WebResult(ResultCode resultCode, T data) {
        this(resultCode.code, resultCode.msg, data);
    }

    public WebResult(Integer code, String msg) {
        this(code, msg, null);
    }
}
