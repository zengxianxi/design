package com.xianxi.study.design.proxy.javassist;

import com.xianxi.study.design.proxy.DBQuery;
import junit.framework.Assert;
import org.junit.Test;

/**
 * @author zengxianxi
 * @since 13-9-22 上午12:37
 */
public class JavassistProxyFactoryTest {

    @Test
    public void testCreateJavassistFactory() throws InstantiationException, IllegalAccessException {
        DBQuery dbQuery = JavassistProxyFactory.createJavassistProxy();
        String value = dbQuery.request();
        Assert.assertEquals("返回值错误","request string info",value);


    }

    @Test
    public void testCreateJavassistBytecodeProxy() throws Exception {
        DBQuery dbQuery = JavassistProxyFactory.createJavassistBytecodeProxy();
        String value = dbQuery.request();
        Assert.assertEquals("返回值错误","request string info",value);


    }
}
