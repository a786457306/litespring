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

public class XmlBeanDefinitionReader {

    private static final String ID_ATTRIBUTE = "id";
    private static final String CLASS_ATTRIBUTE = "class";

    private BeanDefinitionRegistry beanDefinitionRegistry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    /**
     * 从xml文件中读取bean定义（解析xml文件）
     * 并添加 bean 的定义
     *
     * @param resource
     */
    public void loadBeanDefinition(Resource resource) {
        InputStream input = null;
        try {
            input = resource.getInputStream();
            SAXReader reader = new SAXReader();
            Document doc = reader.read(input);

            Element rootElement = doc.getRootElement();
            Iterator<Element> elementIterator = rootElement.elementIterator();

            while (elementIterator.hasNext()) {

                Element element = elementIterator.next();
                String beanId = element.attributeValue(ID_ATTRIBUTE);
                String beanClass = element.attributeValue(CLASS_ATTRIBUTE);

                BeanDefinition beanDefinition = new GenericBeanDefinition(beanId, beanClass);

                this.beanDefinitionRegistry.registerBeanDefinition(beanId, beanDefinition);
            }

        } catch (Exception e) {
            throw new BeanDefinitionStoreException("IOException parsing XML document", e);
        } finally {
            if (!(input == null)) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
