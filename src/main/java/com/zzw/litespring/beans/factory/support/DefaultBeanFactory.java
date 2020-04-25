package com.zzw.litespring.beans.factory.support;

import com.zzw.litespring.beans.BeanDefinition;
import com.zzw.litespring.beans.factory.BeanCreationException;
import com.zzw.litespring.beans.factory.config.ConfigurableBeanFactory;
import com.zzw.litespring.utils.ClassUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 接口的实现，放到support包中
 * 职责分离，每个类单一职责
 * 只是bean相关，没有xml相关的代码
 */
public class DefaultBeanFactory implements ConfigurableBeanFactory, BeanDefinitionRegistry {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private ClassLoader beanClassLoader;

    public DefaultBeanFactory() {}

    /**
     * 获取bean定义
     *
     * @param beanId
     * @return
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanId) {

        return this.beanDefinitionMap.get(beanId);

    }

    /**
     * 将beanId与beanDefinition的映射关系添加到map中
     *
     * @param beanId
     * @param beanDefinition
     */
    @Override
    public void registerBeanDefinition(String beanId, BeanDefinition beanDefinition) {

        this.beanDefinitionMap.put(beanId, beanDefinition);

    }

    /**
     * 根据bean定义获取className，并根据此加载class
     * 获取bean实例
     *
     * @param beanId
     * @return
     */
    @Override
    public Object getBean(String beanId) {

        BeanDefinition beanDefinition = getBeanDefinition(beanId);

        if (beanDefinition == null) {
            throw new BeanCreationException("BeanDefinition does not exist!");
        }

        ClassLoader classLoader = this.getClassLoader();
        String beanClassName = beanDefinition.getBeanClassName();

        try {

            Class<?> beanClass = classLoader.loadClass(beanClassName);
            return beanClass.newInstance();

        } catch (Exception e) {

            throw new BeanCreationException("create bean for " + beanClassName + " failed", e);

        }
    }

    @Override
    public void setClassLoader(ClassLoader classLoader) {
        this.beanClassLoader = classLoader;
    }

    @Override
    public ClassLoader getClassLoader() {
        return (this.beanClassLoader == null ? ClassUtils.getDefaultClassLoader() : this.beanClassLoader);
    }
}
