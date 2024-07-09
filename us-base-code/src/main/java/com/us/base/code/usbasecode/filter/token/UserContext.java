package com.us.base.code.usbasecode.filter.token;

import com.us.base.code.usbasecode.util.BaseUserInfo;

/**
 * 用户上下文
 *
 * @author wufan
 * @date 2024/7/9
 */
public class UserContext {

    private static final ThreadLocal<BaseUserInfo> USER_HOLDER = new ThreadLocal<>();

    protected static void setUser(BaseUserInfo user) {
        USER_HOLDER.set(user);
    }

    public static BaseUserInfo getUser() {
        return USER_HOLDER.get();
    }

    public static Integer getUserId() {
        BaseUserInfo userInfo = USER_HOLDER.get();
        return userInfo == null ? null : userInfo.getUserId();
    }

    public static String getUserName() {
        BaseUserInfo userInfo = USER_HOLDER.get();
        return userInfo == null ? null : userInfo.getUserName();
    }

    protected static void clear() {
        USER_HOLDER.remove();
    }
}
