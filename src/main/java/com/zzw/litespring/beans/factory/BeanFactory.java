package com.zzw.litespring.beans.factory;

/**
 * 获取bean实例
 *
 * Author: Daydreamer
 * Date:2019/4/14
 */
public interface BeanFactory {
    Object getBean(String beanID);
}
