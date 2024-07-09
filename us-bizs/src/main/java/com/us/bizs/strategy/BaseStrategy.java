package com.us.bizs.strategy;

/**
 * 基础策略类
 *
 * @author wufan
 * @date 2024/7/9
 */
public interface BaseStrategy<T> {

    /**
     * 执行策略
     *
     * @param data 执行的参数
     */
    void execute(T data);

}
