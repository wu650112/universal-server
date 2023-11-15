package com.us.base.code.usbasecode.util;

import org.springframework.util.DigestUtils;

/**
 * 编码工具类
 *
 * @author wufan
 * @date 2023/9/4
 */
public class UsCodeUtil {

    /**
     * 获取md5值
     */
    public static String md5Hex(byte[] bytes) {
        return DigestUtils.md5DigestAsHex(bytes);
    }
}
