package com.wyl.xue.security.handle;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname PreAuthenticationSuccessHandler
 * @Description 登录成功处理器
 * @Author Created by Lihaodong (alias:小东啊) lihaodongmail@163.com
 * @Date 2019-07-08 13:50
 * @Version 1.0
 */
@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        Object principal = authentication.getPrincipal();
//        (principal instanceof PreSocialUser) {
//            PreSocialUser userDetail = (PreSocialUser) authentication.getPrincipal();
//            PreSecurityUser preSecurityUser = new PreSecurityUser(Integer.parseInt(userDetail.getUserId()), userDetail.getUsername(), userDetail.getPassword(), userDetail.getAuthorities(), null);
//            //存储认证信息
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            //生成token
//            String token = JwtUtil.generateToken(preSecurityUser);
//            response.sendRedirect(url + "/login?token=" + token);
//        }

    }
}

