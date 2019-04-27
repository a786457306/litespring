package com.zzw.litespring.beans.factory.config;

/**
 * Author: Daydreamer
 * Date:2019/4/18
 */
public interface PrototypeBeanRegistry {

    void registerPrototype(String beanName, Object prototypeObject);

    Object getPrototype(String beanName);
}
