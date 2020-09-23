package com.wyl.xue.admin.system.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wyl.xue.admin.system.mybatis.entity.SystemRoles;
import lombok.Data;

/**
 * @ClassName: RoleInto
 * @Function: 前端角色信息
 * @Date: 2020/9/22 15:41
 * @author wangyl
 * @version V1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RoleInto {
    private Long roleId;
    private String roleName;

    public RoleInto(SystemRoles systemRoles) {
        this.roleId = systemRoles.getRoldId();
        this.roleName = systemRoles.getRoleName();
    }
}
