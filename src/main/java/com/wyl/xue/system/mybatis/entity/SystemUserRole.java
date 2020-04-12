package com.wyl.xue.system.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassName: SystemRoleDepartment
 * @Function: 角色与部门对应关系
 * @Date: 2019/12/17 13:57
 * @author wangyl
 * @version V1.0
 */
@Data
@Builder
@TableName("system_user_role")
public class SystemUserRole extends SystemBase {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    private String UserId;
    /**
     * 角色ID
     */
    private String roleId;
}
