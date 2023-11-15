package com.us.base.code.usbasecode.util;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 字节工具类
 *
 * @author wufan
 * @date 2023/9/4
 */
public class UsByteUtil {

    public static String readRawRequestBody(HttpServletRequest request) throws IOException {
        // 获取请求体输入流
        ServletInputStream inputStream = request.getInputStream();
        // 用 BufferedReader 读取输入流
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder body = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            body.append(line);
        }
        // 请求体内容现在存储在 body 变量中
        return body.toString();
    }

    /**
     * byte2Str
     */
    public static String byte2Str(byte[] bytes) {
        if (bytes == null || bytes.length < 1) {
            return null;
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
