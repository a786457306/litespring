package com.zzw.litespring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 读取xml文件工具类
 *
 * Author: Daydreamer
 * Date:2019/4/15
 */
public interface Resource {
    public InputStream getInputStream() throws IOException;

    public String getDescription();
}
