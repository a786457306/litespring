package com.zzw.litespring.beans.factory.support;

import com.zzw.litespring.beans.BeanDefinition;

public interface BeanDefinitionRegistry {

    /**
     * 获取bean定义
     *
     * @param beanId
     * @return
     */
    BeanDefinition getBeanDefinition(String beanId);

    /**
     * 将bean和读取到的bean定义进行映射
     *
     * @param beanId
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanId, BeanDefinition beanDefinition);
}
