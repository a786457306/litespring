package com.zzw.litespring.test.v1;

import com.zzw.litespring.beans.BeanDefinition;
import com.zzw.litespring.beans.factory.BeanFactory;
import com.zzw.litespring.beans.factory.support.DefaultBeanFactory;
import com.zzw.litespring.service.v1.PetStoreService;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * 测试BeanFactory
 */
public class BeanFactoryTest {

    /**
     * 测试获取bean的实例
     *
     * 首先新建BeanFactory bean工厂，读取xml中的配置并创建对应的Bean
     * 然后根据配置文件中的设置，指定从创建的Bean中获取某个对应的BeanDefinition
     * 判断bean定义是否正确，即创建的Bean是否是配置文件中指定的bean（类的限定名是否相同）
     * 判断是否成功创建了Bean实例（创建实例，判断是否为空）
     */
    @Test
    public void testGetBean() {
        // Bean工厂
        BeanFactory beanFactory = new DefaultBeanFactory("petstore-v1.xml");

        // Bean工厂创建Bean定义
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("petStore");

        assertEquals("com.zzw.litespring.service.v1.PetStoreService", beanDefinition.getBeanClassName());

        // 工厂创建Bean实例
        PetStoreService petStoreService = (PetStoreService) beanFactory.getBean("petStore");

        assertNotNull(petStoreService);

    }
}
