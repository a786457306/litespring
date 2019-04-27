package com.zzw.litespring.context.support;

import com.zzw.litespring.beans.factory.support.DefaultBeanFactory;
import com.zzw.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import com.zzw.litespring.context.ApplicationContext;
import com.zzw.litespring.core.io.FileSystemResource;
import com.zzw.litespring.core.io.Resource;

/**
 * 从文件系统中读取xml文件加载bean的方式
 *
 * Author: Daydreamer
 * Date:2019/4/15
 */
public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

    public FileSystemXmlApplicationContext(String configFile) {
        super(configFile);
    }

    @Override
    protected Resource getResourceByPath(String path) {
        return new FileSystemResource(path);
    }

}
