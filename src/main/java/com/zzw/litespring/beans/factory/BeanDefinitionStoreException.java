package com.zzw.litespring.beans.factory;

import com.zzw.litespring.beans.BeanException;

/**
 * 读取配置文件时的exception
 */
public class BeanDefinitionStoreException extends BeanException {

    public BeanDefinitionStoreException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
