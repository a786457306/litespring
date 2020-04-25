package com.zzw.litespring.context.support;

import com.zzw.litespring.core.io.FileSystemResource;
import com.zzw.litespring.core.io.Resource;

public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

    public FileSystemXmlApplicationContext(String configFilePath) {
        super(configFilePath);
    }

    @Override
    Resource getResourceByPath(String path) {
        return new FileSystemResource(path);
    }
}
