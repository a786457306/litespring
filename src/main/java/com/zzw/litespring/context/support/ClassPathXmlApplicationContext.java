package com.zzw.litespring.context.support;

import com.zzw.litespring.beans.factory.support.DefaultBeanFactory;
import com.zzw.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import com.zzw.litespring.context.ApplicationContext;
import com.zzw.litespring.core.io.ClassPathResource;
import com.zzw.litespring.core.io.Resource;

/**
 * ClassPath读取xml文件的方式加载bean
 *
 * Author: Daydreamer
 * Date:2019/4/15
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String configFile) {
        super(configFile);
    }

    @Override
    protected Resource getResourceByPath(String path) {
        return new ClassPathResource(path, this.getBeanClassloader());
    }
}
