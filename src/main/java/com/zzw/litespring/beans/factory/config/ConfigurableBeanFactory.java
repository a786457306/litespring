package com.zzw.litespring.beans.factory.config;

import com.zzw.litespring.beans.factory.BeanFactory;

/**
 * 将ClassLoader配置单独封装到类中
 *
 * Author: Daydreamer
 * Date:2019/4/16
 */
public interface ConfigurableBeanFactory extends BeanFactory {

    void setBeanClassLoader(ClassLoader beanClassLoader);

    ClassLoader getBeanClassloader();
}
