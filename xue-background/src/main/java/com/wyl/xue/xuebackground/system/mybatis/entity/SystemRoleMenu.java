package com.wyl.xue.xuebackground.system.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wyl.xue.core.mybatis.entity.SystemBase;
import lombok.Builder;
import lombok.Data;

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
public class SystemRoleMenu extends SystemBase {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 菜单ID
     */
    private Long menuId;

}
