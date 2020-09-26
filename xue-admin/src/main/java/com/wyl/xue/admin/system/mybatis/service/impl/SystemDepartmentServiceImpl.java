package com.wyl.xue.admin.system.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.admin.system.mybatis.entity.SystemDepartment;
import com.wyl.xue.admin.system.mybatis.mapper.SystemDepartmentMapper;
import com.wyl.xue.admin.system.mybatis.service.SystemDepartmentService;
import com.wyl.xue.admin.system.mybatis.service.SystemUsersService;
import com.wyl.xue.admin.system.vo.DepartmentTree;
import com.wyl.xue.core.util.exception.BizException;
import com.wyl.xue.core.util.result.ResultCode;
import com.wyl.xue.core.util.tree.TreeUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName: SystemDepartmentServiceImpl
 * @Function: 部门
 * @Date: 2019/12/18 22:11
 * @author wyl
 * @version V1.0
 */
@Service
@Slf4j
@AllArgsConstructor
@DS("master")
public class SystemDepartmentServiceImpl extends ServiceImpl<SystemDepartmentMapper, SystemDepartment> implements SystemDepartmentService {

    final SystemUsersService systemUsersService;

    /**
     * @Description 获取部门的树形信息
     * @return com.wyl.xue.system.vo.DepartmentTree
     * @Date 2020/3/27 17:46
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public List<DepartmentTree> getDepartmentTree(Object root) {
        List<SystemDepartment> systemDepartmentList = this.list();
        List<DepartmentTree> departmentTreeList = new ArrayList<>();
        systemDepartmentList.stream()
                            .forEach(systemDepartment -> {
                                DepartmentTree departmentTree = new DepartmentTree(systemDepartment.getDepartmentId(), systemDepartment.getParentId(), systemDepartment.getDepartmentName());
                                departmentTreeList.add(departmentTree);
                            });
        return TreeUtil.bulid(departmentTreeList, root, null);
    }

    /**
     * @Description 获取指定id的树的所有子节点id
     * @param id 指定id
     * @return java.util.List<java.lang.String>
     * @Date 2020/3/30 22:17
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public List<Object> getDepartmentTreeById(Long id) {
        List<Object> resultIdList = new ArrayList<>();
        List<DepartmentTree> departmentTreeList = this.getDepartmentTree(id);
        TreeUtil.getTreeChildrenId(departmentTreeList, resultIdList);
        resultIdList.add(id);
        return resultIdList;
    }

    /**
     * @Description 获取指定部门下的所有一级子菜单
     * @param id 部门id
     * @return java.util.List<com.wyl.xue.system.mybatis.entity.SystemDepartment>
     * @Date 2020/4/12 23:17
     * @Author wangyl
     * @Version V1.0
     */
    @Override
    public IPage<SystemDepartment> getSubdirectoryById(Long id, Integer page, Integer size) {
        Page<SystemDepartment> pageInfo = new Page<>(page, size);
        IPage<SystemDepartment> systemDepartmentPage = this.page(pageInfo, Wrappers.<SystemDepartment>lambdaQuery().eq(SystemDepartment::getParentId, id));
        return systemDepartmentPage;
    }

    @Override
    public boolean removeById(Serializable id) {
        if (systemUsersService.getSystemUsersByDepartmentId(Long.valueOf(id.toString()))
                              .isEmpty()) {
            return super.removeById(id);
        } else {
            throw new BizException(ResultCode.HAVERESOURCES);
        }
    }
}
