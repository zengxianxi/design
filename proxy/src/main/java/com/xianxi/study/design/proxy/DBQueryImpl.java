package com.xianxi.study.design.proxy;

/**
 * @author zengxianxi
 * @since 13-9-20 下午5:54
 */
public class DBQueryImpl implements DBQuery {

    public DBQueryImpl(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String request() {
        return "request string info";
    }
}
