package com.zzw.litespring.beans.factory;

import com.zzw.litespring.beans.BeansException;

/**
 * Bean存储错误的时候抛出的Exception
 *
 * Author: Daydreamer
 * Date:2019/4/14
 */
public class BeanDefinitionStoreException extends BeansException {

    public BeanDefinitionStoreException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
