package com.xianxi.study.design.proxy.cglib;

import com.xianxi.study.design.proxy.DBQuery;
import junit.framework.Assert;
import org.junit.Test;

/**
 * @author zengxianxi
 * @since 13-9-21 上午10:11
 */
public class CglibPorxyFactoryTest {
    @Test
    public void testCreateCglibProxy() throws Exception {
        DBQuery dbQuery = CglibPorxyFactory.createCglibProxy();

        String value = dbQuery.request();

        Assert.assertEquals("返回借值错误", "request string info", value);

    }
}
