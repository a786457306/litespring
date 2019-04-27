package com.zzw.litespring.beans;

/**
 * 封装Exception类
 *
 * Author: Daydreamer
 * Date:2019/4/14
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
