package com.xianxi.study.design.master_worker;

/**
 * 计算立方
 * @author zengxianxi
 * @since 13-10-3 下午4:21
 */
public class PlusWoker extends Worker {
    @Override
    protected Object handle(Object input) {
        Integer i = (Integer)input;
        return i * i * i;
    }
}
