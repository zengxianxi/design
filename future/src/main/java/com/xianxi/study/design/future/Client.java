package com.xianxi.study.design.future;

/**
 * 请求数据的客户端
 * @author zengxianxi
 * @since 13-10-3 下午2:09
 */
public class Client {
    /**
     * 请求数据
     * @param queryStr，请求的内容
     * @return
     */
    public Data request(final String queryStr){
        final FutureData futureData = new FutureData();
        //因为RealData构造的很慢，所以另开一个线程来执行
        new Thread(){
            @Override
            public void run() {
                RealData realData = new RealData(queryStr);
                futureData.setData(realData);
            }
        }.start();
       return futureData;
    }
}
