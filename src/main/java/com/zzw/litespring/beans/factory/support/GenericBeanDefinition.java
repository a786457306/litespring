package com.zzw.litespring.beans.factory.support;

import com.zzw.litespring.beans.BeanDefinition;

public class GenericBeanDefinition implements BeanDefinition {

    private String beanId;

    private String beanClass;


    public GenericBeanDefinition(String beanId, String beanClass) {
        this.beanId = beanId;
        this.beanClass = beanClass;
    }

    @Override
    public String getBeanClassName() {
        return this.beanClass;
    }
}
