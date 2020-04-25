package com.zzw.litespring.core.io;

import java.io.IOException;
import java.io.InputStream;

public interface Resource {

    /**
     * 获取输入流
     *
     * @return
     * @throws IOException
     */
    public InputStream getInputStream() throws IOException;

    /**
     * 获取描述
     *
     * @return
     */
    public String getDescription();
}
