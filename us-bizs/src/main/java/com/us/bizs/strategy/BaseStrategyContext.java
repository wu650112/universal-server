package com.us.bizs.strategy;

/**
 * 策略上下文
 *
 * @author wufan
 * @date 2024/7/9
 */
public class BaseStrategyContext<T> {

    private BaseStrategy<T> strategy;

    public BaseStrategyContext(BaseStrategy<T> strategy) {
        // 可以通过构造函数注入策略
        this.strategy = strategy;
    }

    public void setStrategy(BaseStrategy<T> strategy) {
        // 通过setter方法设置策略
        this.strategy = strategy;
    }

    public void executeStrategy(T t) {
        // 执行策略方法
        strategy.execute(t);
    }
}
