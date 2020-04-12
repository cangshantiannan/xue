package com.wyl.xue.system.mybatis.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wyl.xue.system.mybatis.entity.SystemDepartment;
import com.wyl.xue.system.vo.DepartmentTree;

import java.util.List;

/**
 * @ClassName: SystemDepartmentService
 * @Function: 部门表的service
 * @Date: 2019/12/18 21:52
 * @author wangyl
 * @version V1.0
 */
public interface SystemDepartmentService extends IService<SystemDepartment> {

    /**
     * @Description 获取部门的树形信息
     * @param
     * @return com.wyl.xue.system.vo.DepartmentTree
     * @Date 2020/3/27 17:46
     * @Author wangyl
     * @Version V1.0
     */
    List<DepartmentTree> getDepartmentTree();

    /**
     * @Description 获取指定id的树的所有子节点id
     * @param id 指定id
     * @return java.util.List<java.lang.String>
     * @Date 2020/3/30 22:17
     * @Author wangyl
     * @Version V1.0
     */
    List<Object> getDepartmentTreeById(String id);

    /**
     * @Description 获取指定部门下的所有一级子菜单
     * @param id 部门id
     * @return java.util.List<com.wyl.xue.system.mybatis.entity.SystemDepartment>
     * @Date 2020/4/12 23:17
     * @Author wangyl
     * @Version V1.0
     */
    List<SystemDepartment> getSubdirectoryById(String id);

}
