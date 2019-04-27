package com.zzw.litespring.test.v1;

import com.zzw.litespring.core.io.ClassPathResource;
import com.zzw.litespring.core.io.FileSystemResource;
import com.zzw.litespring.core.io.Resource;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * 测试两种读取文件的方式
 *
 * Author: Daydreamer
 * Date:2019/4/15
 */
public class ResourceTest {
    @Test
    public void testClassPathResource() throws Exception {

        Resource r = new ClassPathResource("petstore-v1.xml");

        InputStream is = null;

        try {
            is = r.getInputStream();
            // 注意：这个测试其实并不充分！！应该检查inputstream输入流，与文件进行比对
            Assert.assertNotNull(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }

    }

    @Test
    public void testFileSystemResource() throws Exception {

        // 使用相对路径
		Resource r = new FileSystemResource("src\\test\\resources\\petstore-v1.xml");

		InputStream is = null;

		try {
			is = r.getInputStream();
			// 注意：这个测试其实并不充分！！
			Assert.assertNotNull(is);
		} finally {
			if (is != null) {
				is.close();
			}
		}

    }

}
