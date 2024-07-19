package com.us.bizs.unit;

import com.us.bizs.unit.obj.BhrTreeNode;

import java.util.List;

/**
 * 通用树状方法
 *
 * @author wufan
 * @date 2024/7/1
 */
public interface TreeNodeProcessor<T extends BhrTreeNode<T>> {

    /**
     * 初始化树状结构
     *
     * @param sourceTree 源数据
     * @return List<T> 初始化后的数据
     */
    List<T> initTree(List<T> sourceTree);

    /**
     * 初始化树状结构
     * 一开始是没有父子结构的，先从数据库查询出来列数据，在初始化到childList属性里面去
     *
     * @param sourceTree  源数据
     * @param isLevelTree 这个树结构是否有层级属性，有的话处理起来更方便
     * @return List<T> 初始化后的数据
     */
    List<T> initTree(List<T> sourceTree, boolean isLevelTree);
}
