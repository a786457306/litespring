package com.zzw.litespring.context.support;

import com.zzw.litespring.core.io.ClassPathResource;
import com.zzw.litespring.core.io.Resource;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String configFilePath) {
        super(configFilePath);
    }

    @Override
    Resource getResourceByPath(String path) {
        return new ClassPathResource(path, this.getClassLoader());
    }

}
