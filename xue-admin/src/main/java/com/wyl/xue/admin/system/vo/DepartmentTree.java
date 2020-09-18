package com.wyl.xue.admin.system.vo;

import com.wyl.xue.core.util.tree.BaseTree;

/**
 * @ClassName: DepartmentTree
 * @Function: 部门树结构
 * @Date: 2020/3/27 17:44
 * @author wangyl
 * @version V1.0
 */
public class DepartmentTree extends BaseTree {
    public DepartmentTree(String id, String parent_id, String name) {
        super(id, parent_id, name);
    }
}
