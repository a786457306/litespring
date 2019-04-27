package com.zzw.litespring.beans.factory.support;

import com.zzw.litespring.beans.factory.config.PrototypeBeanRegistry;
import com.zzw.litespring.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: Daydreamer
 * Date:2019/4/18
 */
public class DefaultPrototypeBeanRegistry implements PrototypeBeanRegistry {

    private final Map<String, Object> prototypeObjects = new ConcurrentHashMap<>(64);

    @Override
    public void registerPrototype(String beanName, Object prototypeObject) {
        Assert.notNull(beanName, "beanName must not be null!");

    }

    @Override
    public Object getPrototype(String beanName) {
        return null;
    }
}
