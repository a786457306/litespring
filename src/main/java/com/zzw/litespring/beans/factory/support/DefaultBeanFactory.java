package com.zzw.litespring.beans.factory.support;

import com.zzw.litespring.beans.BeanDefinition;
import com.zzw.litespring.beans.factory.BeanFactory;

/**
 * 接口的实现，放到support包中
 */
public class DefaultBeanFactory implements BeanFactory {
    public DefaultBeanFactory(String configFile) {
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return null;
    }

    @Override
    public Object getBean(String beanId) {
        return null;
    }
}
