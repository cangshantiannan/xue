package com.wyl.xue.util;

import lombok.*;
import org.springframework.http.HttpStatus;
import java.io.Serializable;


/**
 * @ClassName: WebResult
 * @Function: 返回页面结果信息
 * @Date: 2019/12/16 0:51
 * @author wangyl
 * @version V1.0
 */
@Builder
public class WebResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code = 200;
    private String message;
    private Object data;

    public static WebResult ok() {
        return WebResult.builder().message("操作成功").build();
    }

    public static WebResult ok(Object data) {
        return WebResult.builder().message("操作成功").data(data).build();
    }

    public static WebResult error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    public static WebResult error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static WebResult error(int code, String msg) {
        return WebResult.builder().code(code).message(msg).build();
    }
}
