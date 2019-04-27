package com.zzw.litespring.context.support;

import com.zzw.litespring.beans.factory.support.DefaultBeanFactory;
import com.zzw.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import com.zzw.litespring.context.ApplicationContext;
import com.zzw.litespring.core.io.Resource;
import com.zzw.litespring.util.ClassUtils;

/**
 * 模板方法
 * 删除ApplicationContext下实现类的重复代码
 *
 * Author: Daydreamer
 * Date:2019/4/15
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    private DefaultBeanFactory factory = null;
    private ClassLoader beanClassLoader;

    /**
     * 提供模板方法，消除读取配置文件的重复代码
     *
     * @param configFile
     */
    public AbstractApplicationContext(String configFile) {
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = this.getResourceByPath(configFile);
        reader.loadBeanDefinitions(resource);
        factory.setBeanClassLoader(this.getBeanClassloader());
    }

    /**
     * 由ClassPathXmlApplicationContext和FileSystemXmlApplicationContext实现
     *
     * @param path
     * @return
     */
    protected abstract Resource getResourceByPath(String path);

    @Override
    public Object getBean(String beanID) {
        return factory.getBean(beanID);
    }

    @Override
    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }

    @Override
    public ClassLoader getBeanClassloader() {
        return (this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader());
    }
}
