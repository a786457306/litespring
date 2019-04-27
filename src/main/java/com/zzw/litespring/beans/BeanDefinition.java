package com.zzw.litespring.beans;

/**
 * Bean的所有定义
 * 判断bean是单例还是多例
 *
 * Author: Daydreamer
 * Date:2019/4/14
 */
public interface BeanDefinition {
    public static final String SCOPE_SINGLETON = "singleton";
    public static final String SCOPE_PROTOTYPE = "prototype";
    public static final String SCOPE_DEFAULT = "";

    public boolean isSingleton();

    public boolean isPrototype();

    String getScope();

    void setScope(String scope);

    public String getBeanClassName();
}
