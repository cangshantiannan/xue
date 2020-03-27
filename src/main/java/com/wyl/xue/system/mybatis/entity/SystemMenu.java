package com.wyl.xue.system.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

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
public class SystemMenu extends Model<SystemMenu> {

    /**
     * 菜单ID
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;

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
    private Integer parentId;

    /**
     * 菜单类型 （类型   0：目录   1：菜单   2：按钮）
     */
    private Integer type;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删除标记(1--正常 0--删除)
     */
    private Boolean delFlag;

}
