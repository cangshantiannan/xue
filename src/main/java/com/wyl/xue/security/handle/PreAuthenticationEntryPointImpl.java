package com.wyl.xue.security.handle;

import com.wyl.xue.util.WebResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 认证失败处理类 返回401
 * @author lihaodong
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
//        log.error("请求访问: " + request.getRequestURI() + " 接口， 经jwt认证失败，无法访问系统资源.");
//        SecurityUtil.writeJavaScript(WebResult.error(Status.HTTP_UNAUTHORIZED,"请求访问:" + request.getRequestURI() + "接口,经jwt 认证失败,无法访问系统资源"),response);
    }
}
