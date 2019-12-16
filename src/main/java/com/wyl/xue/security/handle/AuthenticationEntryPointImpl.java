package com.wyl.xue.security.handle;

import com.wyl.xue.util.ResponseUntil;
import com.wyl.xue.util.WebResult;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * @ClassName: AuthenticationEntryPointImpl
 * @Function: 未认证用户处理器
 * @Date: 2019/12/16 14:13
 * @author wangyl
 * @version V1.0
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    /**
     * @Description 连接匿名用户
     * @param request
     * @param response
     * @param e
     * @return void
     * @Date 2019/12/16 14:28
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        ResponseUntil.writeResponse(WebResult.error(HttpStatus.UNAUTHORIZED.value(), "请求访问:" + request.getRequestURI() + "接口,经jwt 认证失败,无法访问系统资源"), response);
    }
}
