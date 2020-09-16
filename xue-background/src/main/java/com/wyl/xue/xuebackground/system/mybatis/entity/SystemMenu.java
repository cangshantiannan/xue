package com.wyl.xue.xuebackground.system.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wyl.xue.core.mybatis.entity.SystemBase;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassName: SystemMenu
 * @Function: 菜单列表
 * @Date: 2019/12/17 11:35
 * @author wangyl
 * @version V1.0
 */
@Data
@Builder
@TableName("system_menu")
public class SystemMenu extends SystemBase {

    /**
     * 菜单ID
     */
    @TableId(value = "menu_id", type = IdType.ASSIGN_UUID)
    private Long menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单权限标识
     */
    private String perms;

    /**
     * 父菜单ID
     */
    private String parentId;

    /**
     * 菜单类型 （类型   0：目录   1：菜单   2：按钮）
     */
    private Integer type;

    /**
     * 路由信息
     */
    private String routePath;

}
