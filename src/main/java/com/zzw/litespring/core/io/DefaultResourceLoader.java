package com.zzw.litespring.core.io;

import com.zzw.litespring.utils.ClassUtils;

public class DefaultResourceLoader implements ResourceLoader {

    private ClassLoader classLoader = null;

    @Override
    public Resource getResource() {
        return null;
    }

    @Override
    public ClassLoader getCLassLoader() {
        return (this.classLoader == null ? ClassUtils.getDefaultClassLoader() : this.classLoader);
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
}
