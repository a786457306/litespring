package com.zzw.litespring.beans.factory.config;

/**
 * 注册单例bean
 *
 * Author: Daydreamer
 * Date:2019/4/16
 */
public interface SingletonBeanRegistry {

    /**
     * 注册单例bean
     *
     * @param beanName
     * @param singletonObject
     */
    void registerSingleton(String beanName, Object singletonObject);

    /**
     * 获取单例对象
     *
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);
}
