package com.wyl.xue.system.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName: SystemRoleMenu
 * @Function: 角色和菜单关联表
 * @Date: 2019/12/18 0:28
 * @author wangyl
 * @version V1.0
 */
@Data
@Builder
@TableName("system_role_menu")
public class SystemRoleMenu extends Model<SystemRoleMenu> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 菜单ID
     */
    private Integer menuId;

}
