package com.wyl.xue.system.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassName: SystemDepartment
 * @Function: 部门表
 * @Date: 2019/12/15 23:55
 * @author wangyl
 * @version V1.0
 */
@Data
@Builder
@TableName(value = "system_department")
public class SystemDepartment extends SystemBase {
    /**
     * 部门主键ID
     */
    @TableId(value = "department_id", type = IdType.ASSIGN_UUID)
    private String departmentId;

    /**
     * 部门名称
     */
    private String departmentName;


    /**
     * 上级部门
     */
    private String parentId;

}