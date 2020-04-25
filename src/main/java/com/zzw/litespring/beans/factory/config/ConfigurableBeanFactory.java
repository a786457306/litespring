package com.zzw.litespring.beans.factory.config;

import com.zzw.litespring.beans.factory.BeanFactory;

/**
 * 设置可配置的BeanFactory
 * 每个类都用到了ClassLoader，但因为外界没有传入，所以用的都是ClassUtils写死的ClassLoader
 * 还是希望可以用传入的ClassLoader
 */
public interface ConfigurableBeanFactory extends BeanFactory {

    void setClassLoader(ClassLoader classLoader);

    ClassLoader getClassLoader();
}
