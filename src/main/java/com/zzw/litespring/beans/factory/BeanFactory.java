package com.zzw.litespring.beans.factory;

/**
 * 供调用的接口
 */
public interface BeanFactory {

    /**
     * 获取具体的bean实例
     *
     * @param beanId
     * @return
     */
    Object getBean(String beanId);
}
