package com.xianxi.study.design.future;

/**
 * @author zengxianxi
 * @since 13-10-3 下午2:14
 */
public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        Data data = client.request("name");
        System.out.println("请求完毕");
        try {
            //这里可以先处理其它的业务，在处理其它业务的同时，另一个线程正在构建Data的真实数据
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //使用真实数据
        System.out.println("data = " + data.getResult());
    }

}
