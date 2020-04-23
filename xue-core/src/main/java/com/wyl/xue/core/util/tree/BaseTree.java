package com.wyl.xue.core.util.tree;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description 基础树
 * @Date 2019/9/24 14:37
 * @Param
 * @return
 * @Author wangyl
 * @Version V1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseTree extends TreeNode<BaseTree> {
    private String name;

    public BaseTree(Object id, Object parent_id, String name) {
        this.name = name;
        this.setId(id);
        this.setParent_id(parent_id);
    }
}
