package com.xianxi.study.design.observer;

/**
 * 观察者接口
 *
 * @author zengxianxi
 * @since 13-9-22 下午1:40
 */
public interface MyObserver {
    /**
     * 更新观察者
     *
     * @param event
     */
    void update(MyEvent event);
}
