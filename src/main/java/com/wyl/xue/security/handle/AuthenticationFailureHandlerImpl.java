package com.wyl.xue.security.handle;


import com.wyl.xue.util.ResponseUtil;
import com.wyl.xue.util.WebResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: AuthenticationFailureHandler
 * @Function: 登录失败处理器
 * @Date: 2019/12/16 14:29
 * @author wangyl
 * @version V1.0
 */
@Component
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        String message = "认证失败，请联系网站管理员！";
        ResponseUtil.writeResponse(WebResult.error(message), response);
    }
}


