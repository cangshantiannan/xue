/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.system.vo;

import com.wyl.xue.util.tree.BaseTree;

/**
 * @ClassName: MenuTree
 * @Function: 菜单树
 * @Date: 2020/4/8 23:52
 * @author wyl
 * @version V1.0
 */
public class MenuTree extends BaseTree {
    public MenuTree(String id, String parent_id, String name) {
        super(id, parent_id, name);
    }
}
