package com.xianxi.study.design.producer_consumer;

/**
 * 数据
 *
 * @author zengxianxi
 * @since 13-10-4 上午2:23
 */
public class PCData {

    private final int data;


    public PCData(int i) {
        this.data = i;
    }

    public int getData() {
        return data;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "data=" + data +
                '}';
    }
}
