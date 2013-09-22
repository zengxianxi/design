package com.xianxi.study.design.proxy;

/**
 * 定义一个DBQuery的代理类，代理DBQueryImpl，可以节省初始化时间，在需要请调用request方法时才进行初始化；
 *
 * @author zengxianxi
 * @since 13-9-20 下午5:55
 */
public class DBQueryProxy implements DBQuery {

    private DBQuery dbQuery;

    /**
     * 代理request请求
     *
     * @return
     */
    @Override
    public String request() {
        if (dbQuery == null) {
            dbQuery = new DBQueryImpl();
        }
        return dbQuery.request();
    }
}
