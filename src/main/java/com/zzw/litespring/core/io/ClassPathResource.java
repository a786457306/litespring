package com.zzw.litespring.core.io;

import com.zzw.litespring.utils.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource implements Resource {

    private String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {

        this(path, null);

    }

    public ClassPathResource(String path, ClassLoader classLoader) {

        this.path = path;
        this.classLoader = (classLoader == null) ? ClassUtils.getDefaultClassLoader() : classLoader;

    }

    /**
     * 获取输入流
     *
     * @return
     * @throws IOException
     */
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream input = this.classLoader.getResourceAsStream(this.path);
        if (input == null) {
            throw new FileNotFoundException(path + "cannot be opened");
        }
        return input;
    }

    @Override
    public String getDescription() {
        return this.path;
    }

}
