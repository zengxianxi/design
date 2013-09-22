package com.xianxi.study.design.proxy;

/**
 * 数据库请求的实例
 *
 * @author zengxianxi
 * @since 13-9-20 下午5:52
 */
public interface DBQuery {
    /**
     * 数据库请求的方法
     *
     * @return
     */
    String request();
}
