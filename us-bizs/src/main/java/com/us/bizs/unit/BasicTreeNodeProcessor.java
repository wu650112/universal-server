package com.us.bizs.unit;

import com.us.bizs.unit.obj.BhrTreeNode;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 通用树形结构处理器
 *
 * @author wufan
 * @date 2024/7/1
 */
public abstract class BasicTreeNodeProcessor<T extends BhrTreeNode<T>> implements TreeNodeProcessor<T> {

    @Override
    public List<T> initTree(List<T> sourceTree) {
        return this.defaultInit(sourceTree);
    }

    @Override
    public List<T> initTree(List<T> sourceTree, boolean isLevelTree) {
        if (sourceTree == null || sourceTree.isEmpty()) {
            return sourceTree;
        }
        return isLevelTree ? this.initLevelTree(sourceTree) : this.defaultInit(sourceTree);
    }

    private List<T> initLevelTree(List<T> treeNodes) {
        // 根据层级分类
        Map<Integer, List<T>> levelMap = treeNodes.stream().collect(Collectors.groupingBy(BhrTreeNode::getTreeLevel));
        // 返回处理后的数据，具体实现根据业务逻辑修改
        // 找出最小的层级作为顶层节点
        Integer minLevel = levelMap.keySet().stream()
                .min(Integer::compareTo)
                .orElse(null);

        // 如果没有找到任何层级，则直接返回原始列表
        if (minLevel == null) {
            return treeNodes;
        }

        // 获取最小层级对应的节点列表作为顶层节点
        List<T> topNodes = levelMap.get(minLevel);

        // 循环将下一层级作为顶层节点的 childList
        for (T topNode : topNodes) {
            List<T> children = levelMap.getOrDefault(minLevel + 1, Collections.emptyList());
            topNode.setChildList(children);
        }

        return topNodes;
    }

    private List<T> defaultInit(List<T> treeNodes) {
        // 默认找出最顶级节点
        List<T> topNodes = treeNodes.parallelStream().filter(t -> t.getParentId() == null).collect(Collectors.toList());
        if (topNodes.isEmpty()) {
            return treeNodes;
        }

        // 找到最顶级节点才能递归构建树结构
        for (T topNode : topNodes) {
            this.buildTree(topNode, treeNodes);
        }
        return treeNodes;
    }

    /**
     * 递归找子节点
     */
    private void buildTree(T parentNode, List<T> treeNodes) {
        List<T> children = treeNodes.stream()
                .filter(t -> Objects.equals(parentNode.getId(), t.getParentId()))
                .collect(Collectors.toList());

        if (!children.isEmpty()) {
            parentNode.setChildList(children);
            for (T child : children) {
                this.buildTree(child, treeNodes);
            }
        }
    }
}

