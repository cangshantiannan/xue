package com.wyl.xue.security.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName: SecurityUserInfo
 * @Function: 认证的用户信息
 * @Date: 2019/12/17 21:24
 * @author wangyl
 * @version V1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecurityUserInfo implements UserDetails {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     *账户是否未过期,过期无法验证
     */
    private Boolean isAccountNonExpired;
    /**
     *指定用户是否解锁,锁定的用户无法进行身份验证
     */
    private Boolean isAccountNonLocked;
    /**
     *指示是否已过期的用户的凭据(密码),过期的凭据防止认证
     */
    private Boolean isCredentialsNonExpired;
    /**
     *是否可用
     */
    private Boolean isEnabled;
    /**
     *权限列表
     */
    private List<GrantedAuthority> authorities;

    public SecurityUserInfo(Integer userId, String username, String password, List<GrantedAuthority> authorities) {
        this(userId, username, password, true, true, true, true, authorities);
    }

    /**
     * 返回分配给用户的角色列表
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * 账户是否未过期,过期无法验证
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    /**
     * 指定用户是否解锁,锁定的用户无法进行身份验证
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    /**
     * 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    /**
     * 是否可用 ,禁用的用户不能身份验证
     * @return
     */
    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
