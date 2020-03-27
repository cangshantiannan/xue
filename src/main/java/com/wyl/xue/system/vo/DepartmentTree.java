package com.wyl.xue.system.vo;

import com.wyl.xue.util.tree.BaseTree;
import lombok.Builder;

/**
 * @ClassName: DepartmentTree
 * @Function: 部门树结构
 * @Date: 2020/3/27 17:44
 * @author wangyl
 * @version V1.0
 */
public class DepartmentTree extends BaseTree {
    public DepartmentTree(Integer id, Integer parent_id, String name) {
        super(id, parent_id, name);
    }
}
