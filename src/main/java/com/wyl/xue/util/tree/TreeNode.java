package com.wyl.xue.util.tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyl
 * @version V1.0
 * @ClassName: TreeNode
 * @Function: 树节点
 * @Date: 2019/9/24 14:29
 */
@Data
public class TreeNode<T> {
    protected Object id;
    protected Object parent_id;
    protected Integer childrenCount = 0;
    List<T> children = new ArrayList<T>();
    public void add(T node) {
        children.add(node);
        this.childrenCount = this.childrenCount + 1;
    }
}
