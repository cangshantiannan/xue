//package com.wyl.xue.security.user;
//
//import com.baomidou.mybatisplus.core.conditions.Wrapper;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.wyl.xue.system.mybatis.entity.SystemUsers;
//import com.wyl.xue.system.mybatis.service.SystemUsersService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.Set;
//
///**
// * @ClassName: UserDetailsServiceImpl
// * @Function: 用户登录处理
// * @Date: 2019/12/16 17:56
// * @author wangyl
// * @version V1.0
// */
//@Service
//@Slf4j
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private SystemUsersService systemUsersService;
//
//    /**
//     * @Description 通过用户名密码登录
//     * @param username
//     * @return org.springframework.security.core.userdetails.UserDetails
//     * @Date 2019/12/21 21:49
//     * @Author wangyl
//     * @Version V1.0
//     */
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }
//
//    /**
//     * @Description 获取权限用户的权限列表
//     * @param userId
//     * @return java.util.List<org.springframework.security.core.GrantedAuthority>
//     * @Date 2019/12/23 13:34
//     * @Author wangyl
//     * @Version V1.0
//     */
//    private List<GrantedAuthority> getUserAuthorities(Integer userId) {
////        Set<String> perms = systemUsersService.findPermsByUserId(userId);
////        /**
////         *将 SET 权限信息 转化为标准权限信息
////         */
////        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(perms.toArray(new String[0]));
//        return null;
//    }
//}
