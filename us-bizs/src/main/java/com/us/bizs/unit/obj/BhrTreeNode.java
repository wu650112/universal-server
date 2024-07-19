package com.us.bizs.unit.obj;

import lombok.Data;

import java.util.List;

/**
 * 树状类
 *
 * @author wufan
 * @date 2024/7/1
 */
@Data
public class BhrTreeNode<T extends BhrTreeNode<T>> {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 父类id，父类id为空，则默认为最顶级节点
     */
    private Integer parentId;

    /**
     * 层级：如果有的话
     * 比如： 1=xxx  2=xxx  3=xxx 这类的数据结构
     */
    private Integer treeLevel;

    /**
     * 子集
     */
    private List<T> childList;
}
