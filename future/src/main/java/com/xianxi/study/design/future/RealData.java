package com.xianxi.study.design.future;

/**
 * @author zengxianxi
 * @since 13-10-3 下午1:43
 */
public class RealData implements Data {
    protected final String result;

    public RealData(String param) {
        //RealData构造可能很慢，需要等待很久，这里使用sleep模拟
        StringBuilder sb = new StringBuilder();
        try {
            for (int i = 0; i < 10; i++) {
                sb.append(param).append(",");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
