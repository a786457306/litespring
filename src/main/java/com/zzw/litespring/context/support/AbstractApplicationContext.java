package com.zzw.litespring.context.support;

import com.zzw.litespring.beans.factory.support.DefaultBeanFactory;
import com.zzw.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import com.zzw.litespring.context.ApplicationContext;
import com.zzw.litespring.core.io.Resource;
import com.zzw.litespring.utils.ClassUtils;

public abstract class AbstractApplicationContext implements ApplicationContext {

    private DefaultBeanFactory beanFactory = null;

    private ClassLoader beanClassLoader;

    public AbstractApplicationContext(String configFilePath) {
        beanFactory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        Resource resource = this.getResourceByPath(configFilePath);
        reader.loadBeanDefinition(resource);
        beanFactory.setClassLoader(this.getClassLoader());
    }

    @Override
    public Object getBean(String beanId) {
        return beanFactory.getBean(beanId);
    }

    abstract Resource getResourceByPath(String path);

    @Override
    public void setClassLoader(ClassLoader classLoader) {
        this.beanClassLoader = classLoader;
    }

    @Override
    public ClassLoader getClassLoader() {
        return (this.beanClassLoader == null ? ClassUtils.getDefaultClassLoader() : this.beanClassLoader);
    }
}
