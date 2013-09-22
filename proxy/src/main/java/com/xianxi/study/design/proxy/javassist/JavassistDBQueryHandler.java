package com.xianxi.study.design.proxy.javassist;

import com.xianxi.study.design.proxy.DBQuery;
import com.xianxi.study.design.proxy.DBQueryImpl;
import javassist.util.proxy.MethodHandler;

import java.lang.reflect.Method;

/**
 * 定义一个javassist的handler
 *
 * @author zengxianxi
 * @since 13-9-21 下午6:51
 */
public class JavassistDBQueryHandler implements MethodHandler {
    private DBQuery dbQuery;

    @Override
    public Object invoke(Object o, Method method, Method method2, Object[] objects) throws Throwable {
        if (dbQuery == null) {
            dbQuery = new DBQueryImpl();
        }
        String value = dbQuery.request();
        return value;
    }
}
