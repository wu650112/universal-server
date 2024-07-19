package com.us.base.code.usbasecode.util;

/**
 * 对象工具类
 *
 * @author admin
 */
public class UsBeanUtil {

    public static boolean matchStr(String parent, String child) {
        StringBuilder builder = new StringBuilder(child);
        return parent.contains(child) || parent.contains((builder.reverse().toString()));
    }

    public static void main(String[] args) {
        String a = "asd=ashjdbad";
        System.out.println(matchStr("abcdfascew", "wec"));
    }
}
