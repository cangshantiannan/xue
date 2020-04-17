package com.wyl.xue.system.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassName: SystemRoles
 * @Function: 角色信息表
 * @Date: 2019/12/15 23:58
 * @author wangyl
 * @version V1.0
 */
@Data
@Builder
@TableName(value = "system_roles")
public class SystemRoles extends SystemBase{
    /**
     * 角色主键
     */
    @TableId(value = "role_id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色标识
     */
    private String roleCode;

    /**
     * 角色描述
     */
    private String roleDescription;

}