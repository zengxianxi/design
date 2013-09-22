package com.xianxi.study.design.proxy;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author zengxianxi
 * @since 13-9-20 下午6:00
 */
public class DBQueryProxyTest {

    @Test
    public void testRequest() throws Exception {
        DBQuery dbQuery = new DBQueryProxy();
        String value = dbQuery.request();
        assertEquals("返回值错误", "request string info", value);
    }
}
