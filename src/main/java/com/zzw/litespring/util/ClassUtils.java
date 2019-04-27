package com.zzw.litespring.util;

/**
 * 如果没有类加载器，获取默认的classLoader
 *
 * Author: Daydreamer
 * Date:2019/4/14
 */
public abstract class ClassUtils {
    public static ClassLoader getDefaultClassLoader(){
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        if (cl == null) {
            try {
                cl = ClassLoader.getSystemClassLoader();
            } catch (Throwable ex) {
                ex.printStackTrace();
            }
        }
        return cl;
    }
}
