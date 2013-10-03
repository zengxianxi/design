package com.xianxi.study.design.future.jdk;

import java.util.concurrent.Callable;

/**
 * @author zengxianxi
 * @since 13-10-3 下午2:32
 */
public class RealData implements Callable<String> {
    private String param;

    public RealData(String param) {
        this.param = param;
    }

    @Override
    public String call() throws Exception {
        //这里构造真实的数据，或执行真实的业务逻辑
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(param).append(";");
            Thread.sleep(100);
        }
        return sb.toString();
    }
}
