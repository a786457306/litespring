package com.zzw.litespring.beans.factory;

import com.zzw.litespring.beans.BeanDefinition;

/**
 * 供调用的接口
 */
public interface BeanFactory {
    BeanDefinition getBeanDefinition(String beanId);

    Object getBean(String beanId);
}
