/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.xue.security.filter;

import com.wyl.xue.security.UserInfoJwt;
import com.wyl.xue.security.user.UserInfo;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @ClassName: JwtAuthenticationTokenFilter
 * @Function: JWT过滤器 验证jwt的有效性
 * @Date: 2019/12/17 21:18
 * @author wyl
 * @version V1.0
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        Map userInfo = UserInfoJwt.UserInfo(httpServletRequest.getHeader("Authorization"));
        if (!Objects.isNull(userInfo)) {
            UserInfo securityUserInfo = UserInfo.builder().userId(Integer.valueOf(userInfo.get(UserInfoJwt.USERID).toString())).username(userInfo.get(UserInfoJwt.USERNAME).toString()).authorities(null).build();
            Set<String> permissions = null;//userService.findPermsByUserId(securityUser.getUserId());
            Collection<? extends GrantedAuthority> authorities = null;//AuthorityUtils.createAuthorityList(permissions.toArray(new String[0]));
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(securityUserInfo, null, authorities);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
