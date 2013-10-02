package com.xianxi.study.design.observer;

import java.util.Vector;

/**
 * 观察者模式的一个具体实现
 *
 * @author zengxianxi
 * @since 13-9-22 下午1:46
 */
public class ConcreteSubject implements Subject {
    Vector<MyObserver> myObservers = new Vector<MyObserver>();

    @Override
    public void attach(MyObserver observer) {
        myObservers.addElement(observer);
    }

    @Override
    public void detach(MyObserver observer) {
        myObservers.removeElement(observer);
    }

    @Override
    public void inform() {
        MyEvent event = new MyEvent();
        for (MyObserver myObserver : myObservers) {
            myObserver.update(event);
        }
    }
}
