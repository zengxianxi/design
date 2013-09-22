package com.xianxi.study.design.proxy.cglib;

import com.xianxi.study.design.proxy.DBQuery;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 定义一个CGLIB的代理工厂，用于生成代理对象
 *
 * @author zengxianxi
 * @since 13-9-21 上午10:06
 */
public class CglibPorxyFactory {

    public static DBQuery createCglibProxy() {
        Enhancer enhancer = new Enhancer();
        MethodInterceptor interceptor = new CglibDBQueryInterceptor();
        enhancer.setCallback(interceptor);
        enhancer.setInterfaces(new Class[]{DBQuery.class});

        DBQuery proxy = (DBQuery) enhancer.create();
        return proxy;

    }
}
