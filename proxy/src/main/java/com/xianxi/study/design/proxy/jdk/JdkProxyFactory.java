package com.xianxi.study.design.proxy.jdk;

import com.xianxi.study.design.proxy.DBQuery;

import java.lang.reflect.Proxy;

/**
 * 定义一个JDK代理工厂，用于生成动态生成代理对象
 *
 * @author zengxianxi
 * @since 13-9-21 上午9:44
 */
public class JdkProxyFactory {

    /**
     * 创建动态代理对象
     *
     * @return
     */
    public static DBQuery createJdkProxy() {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        JdkDBQueryHandler jdkDBQueryHandler = new JdkDBQueryHandler();
        DBQuery jdkProxy = (DBQuery) Proxy.newProxyInstance(cl, new Class[]{DBQuery.class}, jdkDBQueryHandler);
        return jdkProxy;
    }
}
