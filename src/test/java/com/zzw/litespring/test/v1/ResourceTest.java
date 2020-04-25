package com.zzw.litespring.test.v1;

import com.zzw.litespring.core.io.ClassPathResource;
import com.zzw.litespring.core.io.FileSystemResource;
import com.zzw.litespring.core.io.Resource;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class ResourceTest {

	@Test
	public void testClassPathResource() throws Exception {

		Resource resource = new ClassPathResource("petstore-v1.xml");

		InputStream is = null;

		try {
			is = resource.getInputStream();
			// 注意：这个测试其实并不充分！！应该把inputStream流读出来，和xml文件进行对比
			Assert.assertNotNull(is);
		} finally {
			if (is != null) {
				is.close();
			}
		}

	}

	@Test
	public void testFileSystemResource() throws Exception {

		Resource r = new FileSystemResource("C:\\myCode\\litespring\\src\\test\\resources\\petstore-v1.xml");

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
