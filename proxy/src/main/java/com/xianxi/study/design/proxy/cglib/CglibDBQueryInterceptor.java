package com.xianxi.study.design.proxy.cglib;

import com.xianxi.study.design.proxy.DBQuery;
import com.xianxi.study.design.proxy.DBQueryImpl;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理拦截器
 *
 * @author zengxianxi
 * @since 13-9-21 上午10:01
 */
public class CglibDBQueryInterceptor implements MethodInterceptor {
    private DBQuery dbQuery;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (dbQuery == null) {
            dbQuery = new DBQueryImpl();
        }
        String value = dbQuery.request();
        return value;
    }
}
