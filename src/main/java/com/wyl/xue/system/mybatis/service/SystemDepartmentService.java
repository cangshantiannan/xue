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

}
