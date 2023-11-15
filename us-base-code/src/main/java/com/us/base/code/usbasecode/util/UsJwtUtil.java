package com.us.base.code.usbasecode.util;

import com.us.base.code.usbasecode.base.dao.BaseUserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * token生成工具类
 *
 * @author admin
 */
@Component
public class UsJwtUtil {

    /**
     * 秘钥，用于签名和验证
     */
    private static final String SECRET_KEY = "us-faker";

    @Value("${us.web.token.active.time}")
    private Long expirationTime;

    /**
     * 创建token
     *
     * @param name     用户名字
     * @param username 登录名
     * @return token
     * @date 2023/8/31
     */
    public String generateToken(String username, String name) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("user", username);
        claims.put("name", name);
        if (expirationTime == null || expirationTime < 1) {
            expirationTime = 60 * 60 * 1000L;
        }
        return Jwts.builder()
                .setClaims(claims)
                // 设置过期时间,配置文件获取
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    /**
     * 根据token返回用户信息
     */
    public BaseUserInfo getUserBaseInfo(String token) {
        BaseUserInfo baseUserInfo = new BaseUserInfo();
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        baseUserInfo.setLoginName(String.valueOf(claims.get("user")));
        return baseUserInfo;
    }

    /**
     * 验证token是否有效
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
