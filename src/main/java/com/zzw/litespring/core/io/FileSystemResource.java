package com.zzw.litespring.core.io;


import com.zzw.litespring.utils.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileSystemResource implements Resource {

    private final File file;

    private final String path;

    public FileSystemResource(String path) {

        Assert.notNull(path, "path must not be null!");
        this.file = new File(path);
        this.path = path;

    }

    /**
     * 获取输入流
     *
     * @return
     * @throws IOException
     */
    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    @Override
    public String getDescription() {
        return "file [" + this.file.getAbsolutePath() + "]";
    }
}
