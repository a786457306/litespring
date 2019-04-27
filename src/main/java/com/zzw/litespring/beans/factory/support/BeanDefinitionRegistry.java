package com.zzw.litespring.beans.factory.support;

import com.zzw.litespring.beans.BeanDefinition;

/**
 * 获取、注册bean
 * 与实现相关的接口，放到support中
 *
 * Author: Daydreamer
 * Date:2019/4/14
 */
public interface BeanDefinitionRegistry {

    /**
     * 获取bean定义，即bean名和类名的映射
     *
     * @param beanID
     * @return
     */
    BeanDefinition getBeanDefinition(String beanID);


    void registerBeanDefinition(String beanID, BeanDefinition bd);
}
