package com.us.base.code.usbasecode.base.constant;

/**
 * redis key 常量
 *
 * @author wufan
 * @date 2023/8/29
 */
public interface UsRedisKeyConstant {


    String TOKEN_KEY = "us:token:key";

    /**
     * 幂等校验请求记录
     */
    String IDEMPOTENCE_MAP = "us:idempotence:map";
}
