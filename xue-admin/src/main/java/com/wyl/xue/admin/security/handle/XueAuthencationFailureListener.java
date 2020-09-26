package com.wyl.xue.admin.security.handle;

import com.wyl.xue.core.util.exception.BizException;
import com.wyl.xue.core.util.result.ResultCode;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.*;
import org.springframework.stereotype.Component;

/**
 * @Classname XytAuthencationFailureListener
 * @Description 用户登录失败监听器事件
 * @Author Created by Lihaodong (alias:小东啊) im.lihaodong@gmail.com
 * @Date 2019/12/19 5:24 下午
 * @Version 1.0
 */
@Component
public class XueAuthencationFailureListener implements ApplicationListener<AbstractAuthenticationFailureEvent> {

    @Override
    public void onApplicationEvent(AbstractAuthenticationFailureEvent event) {
        if (event instanceof AuthenticationFailureBadCredentialsEvent) {
            //提供的凭据是错误的，用户名或者密码错误
            throw new BizException(ResultCode.USERNAMEORPASSWORDERROR);
        } else if (event instanceof AuthenticationFailureCredentialsExpiredEvent) {
            //验证通过，但是密码过期
            throw new BizException(ResultCode.PASSWORDPASTDUE);
        } else if (event instanceof AuthenticationFailureDisabledEvent) {
            //验证过了但是账户被禁用
            throw new BizException(ResultCode.ACCOUNTISDISABLED);
        } else if (event instanceof AuthenticationFailureExpiredEvent) {
            //验证通过了，但是账号已经过期
            throw new BizException(ResultCode.ACCOUNTOVERDUE);
        } else if (event instanceof AuthenticationFailureLockedEvent) {
            //账户被锁定
            throw new BizException(ResultCode.ACCOUNTLOCKED);
        } else if (event instanceof AuthenticationFailureServiceExceptionEvent) {
            //其他任何在AuthenticationManager中内部发生的异常都会被封装成此类
            throw new BizException(ResultCode.FAILED);
        }
    }

}