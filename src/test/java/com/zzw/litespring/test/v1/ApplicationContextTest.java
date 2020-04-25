package com.zzw.litespring.test.v1;

import com.zzw.litespring.context.ApplicationContext;
import com.zzw.litespring.context.support.ClassPathXmlApplicationContext;
import com.zzw.litespring.context.support.FileSystemXmlApplicationContext;
import com.zzw.litespring.service.v1.PetStoreService;
import org.junit.Assert;
import org.junit.Test;

public class ApplicationContextTest {

	@Test
	public void testGetBean() {
		// 从classpath下获取一个xml文件来解析
		ApplicationContext context = new ClassPathXmlApplicationContext("petstore-v1.xml");
		PetStoreService petStore = (PetStoreService)context.getBean("petStore");
		Assert.assertNotNull(petStore);
	}
    @Test
	public void testGetBeanFromFileSystemContext(){
	    //注意啊，这里仍然是hardcode了一个本地路径，这是不好的实践!! 如何处理，留作作业
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\liuxin\\git-litespring\\src\\test\\resources\\petstore-v1.xml");
		PetStoreService petStore = (PetStoreService)context.getBean("petStore");
		Assert.assertNotNull(petStore);
		
	}

}
