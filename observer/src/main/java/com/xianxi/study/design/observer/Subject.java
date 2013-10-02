package com.xianxi.study.design.observer;


/**
 * 被观察对象
 *
 * @author zengxianxi
 * @since 13-9-22 下午1:36
 */
public interface Subject {
    /**
     * 添加观察者
     *
     * @param observer
     */
    void attach(MyObserver observer);

    /**
     * 删除观察者
     *
     * @param observer
     */
    void detach(MyObserver observer);

    /**
     * 通知所有观察者
     */
    void inform();

}
