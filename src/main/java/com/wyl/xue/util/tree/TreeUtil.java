package com.wyl.xue.util.tree;


import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * @author wangyl
 * @version V1.0
 * @ClassName: TreeUtil
 * @Function: 建立树型结构
 * @Date: 2019/9/24 14:28
 */
@Data
public class TreeUtil<T extends TreeNode> {
    /**
     * @Description 建立树
     * @Date 2019/9/24 14:33
     * @Param
     * @return
     * @Author wangyl
     * @Version V1.0
     */
    public static <T extends TreeNode> List<T> bulid(List<T> treeNodes, Object root, Comparator comparator) {
        List<T> trees = new ArrayList<T>();
        for (T treeNode : treeNodes) {
            if (root.equals(treeNode.getParent_id())) {
                trees.add(treeNode);
            }

            for (T it : treeNodes) {
                if (it.getParent_id().equals(treeNode.getId())) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<>());
                    }
                    treeNode.add(it);
                }
            }
            if (comparator != null) {
                treeNode.getChildren().sort(comparator);
            }
        }
        if (comparator != null)
            trees.sort(comparator);

        return trees;
    }

    /**
     * @Description 递归建树
     * @Date 2019/9/24 14:34
     * @Param
     * @return
     * @Author wangyl
     * @Version V1.0
     */
    public static <T extends TreeNode> List<T> buildByRecursive(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<T>();
        for (T treeNode : treeNodes) {
            if (root.equals(treeNode.getParent_id())) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * @Description 递归查找子节点
     * @Date 2019/9/24 14:34
     * @Param
     * @return
     * @Author wangyl
     * @Version V1.0
     */
    public static <T extends TreeNode> T findChildren(T treeNode, List<T> treeNodes) {
        for (T it : treeNodes) {
            if (treeNode.getId().equals(it.getParent_id())) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<TreeNode>());
                }
                treeNode.add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }

}
