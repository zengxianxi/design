package com.xianxi.study.design.future;

/**
 * future数据的封装，相当于代理实现
 * @author zengxianxi
 * @since 13-10-3 下午1:42
 */
public class FutureData implements Data {
    protected Data data = null;
    protected boolean isReady = false;

    /**
     * 设置真实数据
     * @param data
     */
    public synchronized void setData(Data data) {
        if (isReady) {
            return;
        }
        this.data = data;
        isReady = true;
        notifyAll();
    }

    @Override
    public synchronized String getResult() {
        try {
            while (!isReady) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return data.getResult();
    }
}
