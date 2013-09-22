package com.xianxi.study.design.proxy.jdk;

import com.xianxi.study.design.proxy.DBQuery;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * @author zengxianxi
 * @since 13-9-21 上午9:52
 */
public class JdkProxyFactoryTest {
    @Test
    public void testCreateJdkProxy() throws Exception {
        DBQuery dbQuery = JdkProxyFactory.createJdkProxy();
        String value = dbQuery.request();
        assertEquals("返回值错误", "request string info", value);


    }
}
