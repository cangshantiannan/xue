/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.xue.xuebackground.security.filter;

import cn.hutool.core.util.ObjectUtil;
import com.wyl.xue.xuebackground.security.UserInfoJwt;
import com.wyl.xue.xuebackground.security.user.SecurityUserInfo;
import com.wyl.xue.xuebackground.system.mybatis.service.SystemUsersService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName: JwtAuthenticationTokenFilter
 * @Function: JWT过滤器 验证jwt的有效性
 * @Date: 2019/12/17 21:18
 * @author wyl
 * @version V1.0
 */
@Component
@AllArgsConstructor
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    final SystemUsersService systemUsersService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = UserInfoJwt.getToken(httpServletRequest);
        if (ObjectUtil.isNotNull(token)) {
            Map UserInfo = UserInfoJwt.UserInfo(token);
            SecurityUserInfo securityUser = new SecurityUserInfo(UserInfo.get("sub").toString(), UserInfo.get("userid").toString(), null, null);
            List<Map> permissions = (List<Map>) UserInfo.get("authorities");
            List<Object> authority = permissions.parallelStream().map(permission -> permission.get("authority")).collect(Collectors.toList());
            List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(authority.toArray(new String[0]));
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(securityUser, null, authorities);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
