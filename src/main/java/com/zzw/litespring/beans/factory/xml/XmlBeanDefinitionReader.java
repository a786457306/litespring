package com.zzw.litespring.beans.factory.xml;

import com.zzw.litespring.beans.BeanDefinition;
import com.zzw.litespring.beans.factory.BeanDefinitionStoreException;
import com.zzw.litespring.beans.factory.support.BeanDefinitionRegistry;
import com.zzw.litespring.beans.factory.support.GenericBeanDefinition;
import com.zzw.litespring.core.io.Resource;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * 专门读取xml配置文件的类，唯一功能
 *
 * Author: Daydreamer
 * Date:2019/4/14
 */
public class XmlBeanDefinitionReader {

    private static final String ID_ATTRIBUTE = "id";
    private static final String CLASS_ATTRIBUTE = "class";
    private static final String SCOPE_ATTRIBUTE = "scope";

    BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    /**
     * 读取配置文件，将读取的bean配置加入map中，即完成注册
     *
     * @param resource
     */
    public void loadBeanDefinitions(Resource resource) {
        InputStream is = null;
        try {
            is = resource.getInputStream();
            SAXReader reader = new SAXReader();
            // xml文件为Document，遍历Document中的元素获取bean信息
            Document doc = reader.read(is);

            // bean标签
            Element root = doc.getRootElement();
            Iterator<Element> it = root.elementIterator();
            while (it.hasNext()) {
                Element ele = (Element) it.next();
                String id = ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
                BeanDefinition beanDefinition = new GenericBeanDefinition(id, beanClassName);
                // 设置bean的scope值
                if (ele.attribute(SCOPE_ATTRIBUTE) != null) {
                    beanDefinition.setScope(ele.attributeValue(SCOPE_ATTRIBUTE));
                }
                this.registry.registerBeanDefinition(id, beanDefinition);
            }
        } catch (Exception e) {
            throw new BeanDefinitionStoreException("IOException parsing XML document from " + resource.getDescription(),e);
        } finally {
            // 关闭输入流
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
