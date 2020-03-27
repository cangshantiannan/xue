///**
// * @Author wangyl
// * @E-mail wangyl@dsgdata.com
// **/
//package com.wyl.xue.security.filter;
//
//import com.wyl.xue.security.UserInfoJwt;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Collection;
//import java.util.Map;
//import java.util.Objects;
//import java.util.Set;
//
///**
// * @ClassName: JwtAuthenticationTokenFilter
// * @Function: JWT过滤器 验证jwt的有效性
// * @Date: 2019/12/17 21:18
// * @author wyl
// * @version V1.0
// */
//@Component
//public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//        filterChain.doFilter(httpServletRequest, httpServletResponse);
//    }
//}