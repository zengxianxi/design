package com.xianxi.study.design.proxy.jdk;

import com.xianxi.study.design.proxy.DBQuery;
import com.xianxi.study.design.proxy.DBQueryImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 定义代理对象的handler
 * @author zengxianxi
 * @since 13-9-21 上午9:17
 */
public class JdkDBQueryHandler implements InvocationHandler {
    DBQuery dbQuery;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (dbQuery == null) {
            dbQuery = new DBQueryImpl();
        }
        String value = dbQuery.request();
        return value;
    }
}
