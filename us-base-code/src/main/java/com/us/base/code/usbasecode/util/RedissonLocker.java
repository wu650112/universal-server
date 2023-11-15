package com.us.base.code.usbasecode.util;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 单点锁
 *
 * @author wufan
 * @date 2023/9/5
 */
@Component
@Slf4j
public class RedissonLocker {

    @Autowired
    private RedissonClient redissonClient;

    public RedissonLocker(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    /**
     * 获取一个分布式锁，如果锁被其他线程或客户端持有，则阻塞直到获取锁成功。
     */
    public RLock lock(String lockKey) {
        RLock lock = this.redissonClient.getLock(lockKey);
        lock.lock();
        return lock;
    }

    /**
     * 获取一个分布式锁，并指定锁的租约时间（以秒为单位）。在指定的租约时间内，锁会自动续租，超过租约时间后锁会自动释放。
     */
    public RLock lock(String lockKey, long leaseTime) {
        RLock lock = this.redissonClient.getLock(lockKey);
        lock.lock(leaseTime, TimeUnit.SECONDS);
        return lock;
    }

    /**
     * 获取一个分布式锁，并指定锁的租约时间和时间单位。可以使用不同的时间单位，例如秒、毫秒等
     */
    public RLock lock(String lockKey, TimeUnit unit, long leaseTime) {
        RLock lock = this.redissonClient.getLock(lockKey);
        lock.lock(leaseTime, unit);
        return lock;
    }

    /**
     * 尝试获取一个分布式锁，但是如果锁被其他线程或客户端持有，会等待一定的时间（waitTime参数指定的时间）
     * 来尝试获取锁，如果在等待时间内获取锁成功，则返回true，否则返回false
     */
    public boolean tryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime) {
        RLock lock = this.redissonClient.getLock(lockKey);

        try {
            return lock.tryLock(waitTime, leaseTime, unit);
        } catch (InterruptedException var9) {
            return false;
        }
    }

    /**
     * 释放指定的分布式锁，如果锁不是当前线程或客户端持有的，则不会执行解锁操作。
     * 通常在完成对资源的操作后，应该调用这个方法来释放锁。
     */
    public void unlock(String lockKey) {
        try {
            RLock lock = this.redissonClient.getLock(lockKey);
            lock.unlock();
        } catch (Exception var3) {
            log.info("redisson unlock fail：key: {}, err: {}", lockKey, var3.getMessage());
        }

    }

    /**
     * 释放由参数lock表示的分布式锁。
     * 这个方法是用于释放通过lock()方法获取的锁
     */
    public void unlock(RLock lock) {
        lock.unlock();
    }

    /**
     * 检查指定的分布式锁是否被持有。如果锁被任何线程或客户端持有，则返回true，否则返回false
     */
    public boolean isLocked(String lockKey) {
        RLock lock = this.redissonClient.getLock(lockKey);
        return lock.isLocked();
    }

    /**
     * 尝试获取分布式锁，并支持线程的中断。
     *
     * @throws InterruptedException
     */
    public RLock lockInterruptibly(String lockKey, long leaseTime, TimeUnit unit) throws InterruptedException {
        RLock lock = this.redissonClient.getLock(lockKey);
        lock.lockInterruptibly(leaseTime, unit);
        return lock;
    }

    /**
     * 尝试获取分布式锁，并支持线程的中断.
     */
    public RLock lockInterruptibly(String lockKey, long leaseTime) throws InterruptedException {
        RLock lock = this.redissonClient.getLock(lockKey);
        lock.lockInterruptibly(leaseTime, TimeUnit.SECONDS);
        return lock;
    }

}
