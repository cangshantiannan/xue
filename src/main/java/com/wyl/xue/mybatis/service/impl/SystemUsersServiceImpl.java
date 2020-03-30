/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.xue.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.mybatis.entity.SystemMenu;
import com.wyl.xue.mybatis.entity.SystemUsers;
import com.wyl.xue.mybatis.mapper.SystemUsersMapper;
import com.wyl.xue.mybatis.service.SystemMenuService;
import com.wyl.xue.mybatis.service.SystemUsersService;
import com.wyl.xue.security.UserInfoJwt;
import com.wyl.xue.security.user.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName: SystemUsersServiceImpl
 * @Function: TODO
 * @Date: 2019/12/18 22:10
 * @author wyl
 * @version V1.0
 */
@Service
@Slf4j
public class SystemUsersServiceImpl extends ServiceImpl<SystemUsersMapper, SystemUsers> implements SystemUsersService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private SystemMenuService systemMenuService;

    @Override
    public String login(String username, String password) {
        Authentication authentication = null;
        try {
            /**
             *调用UserDetailsServiceImpl.loadUserByUsername()去验证用户和密码
             */
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                throw new RuntimeException("用户名或密码错误");
            } else if (e instanceof DisabledException) {
                throw new RuntimeException("账户被禁用");
            } else if (e instanceof AccountExpiredException) {
                throw new RuntimeException("账户过期无法验证");
            } else {
                throw new RuntimeException("账户被锁定,无法登录");
            }
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //生成token
        UserInfo userInfo = (UserInfo) authentication.getPrincipal();
        return UserInfoJwt.generateUserInfoToken(userInfo.getUsername(), userInfo.getAuthorities(), userInfo.getUserId().toString());
    }

    @Override
    public Set<String> findPermsByUserId(Integer userId) {
        List<SystemMenu> systemMenus = systemMenuService.findMenuInfoByUserId(userId);
        Set<String> perms = systemMenus.stream().map(SystemMenu::getPerms).filter(StringUtils::isEmpty).collect(Collectors.toSet());
        if (log.isDebugEnabled()) {
            log.debug("Perms is [{}]", perms);
        }
        return perms;
    }
}
