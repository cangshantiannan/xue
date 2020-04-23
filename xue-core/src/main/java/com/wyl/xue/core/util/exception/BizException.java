/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.core.util.exception;

import com.wyl.xue.core.util.result.ResultCode;
import lombok.Data;

/**
 * @ClassName: BizException
 * @Function: 统一异常
 * @Date: 2020/4/12 20:13
 * @author wyl
 * @version V1.0
 */
@Data
public class BizException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected Integer errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public BizException() {
        super();
    }

    public BizException(ResultCode resultCode) {
        super(resultCode.code.toString());
        this.errorCode = resultCode.code;
        this.errorMsg = resultCode.msg;
    }

    public BizException(ResultCode resultCode, Throwable cause) {
        super(resultCode.code.toString(), cause);
        this.errorCode = resultCode.code;
        this.errorMsg = resultCode.msg;
    }

    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BizException(Integer errorCode, String errorMsg) {
        super(errorCode.toString());
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(Integer errorCode, String errorMsg, Throwable cause) {
        super(errorCode.toString(), cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public String getMessage() {
        return errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
