package com.wyl.xue.admin.system.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wyl.xue.admin.system.mybatis.entity.SystemUsers;
import lombok.Data;

/**
 * @ClassName: UserInfo
 * @Function: 返回给前端的用户信息
 * @Date: 2020/9/22 10:37
 * @author wangyl
 * @version V1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserInfo {
    private String name;
    private String avatar;
    private String introduction;
    private String email;
    private String phoneNumber;
    private Long userId;

    public UserInfo(SystemUsers systemUsers) {
        this.name = systemUsers.getUsername();
        this.avatar = systemUsers.getAvatar();
        this.introduction = "";
        this.email = systemUsers.getEmail();
        this.userId = systemUsers.getUserId();
        this.phoneNumber = systemUsers.getPhoneNumber();
    }
}
