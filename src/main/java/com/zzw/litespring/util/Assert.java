package com.zzw.litespring.util;

/**
 * 自己封装的断言类
 *
 * Author: Daydreamer
 * Date:2019/4/15
 */
public abstract class Assert {
    /**
     * 判断对象是否为空
     *
     * @param object
     * @param message
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}