package com.wyl.xue.system.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.system.mybatis.entity.SystemDepartment;
import com.wyl.xue.system.mybatis.mapper.SystemDepartmentMapper;
import com.wyl.xue.system.mybatis.service.SystemDepartmentService;
import com.wyl.xue.system.vo.DepartmentTree;
import com.wyl.xue.util.tree.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName: SystemDepartmentServiceImpl
 * @Function: TODO
 * @Date: 2019/12/18 22:11
 * @author wyl
 * @version V1.0
 */
@Service
@Slf4j
public class SystemDepartmentServiceImpl extends ServiceImpl<SystemDepartmentMapper, SystemDepartment> implements SystemDepartmentService {
    @Override
    public List<DepartmentTree> getDepartmentTree() {
        List<SystemDepartment> systemDepartmentList = this.list();
        List<DepartmentTree> departmentTreeList = new ArrayList<>();
        systemDepartmentList.stream().forEach(systemDepartment -> {
            DepartmentTree departmentTree = new DepartmentTree(systemDepartment.getDepartmentId(), systemDepartment.getDepartmentId(), systemDepartment.getDepartmentName());
            departmentTreeList.add(departmentTree);
        });
        return TreeUtil.bulid(departmentTreeList, "-1", null);
    }
}
