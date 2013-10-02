package com.xianxi.study.design.observer;

/**
 * 一个观察者的具体实现
 *
 * @author zengxianxi
 * @since 13-9-22 下午1:57
 */
public class ConcreteObserver implements MyObserver {
    @Override
    public void update(MyEvent event) {
        System.out.println("observer receives information");
    }
}
