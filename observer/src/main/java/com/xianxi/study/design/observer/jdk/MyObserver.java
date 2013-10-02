package com.xianxi.study.design.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * 直接实现jdk中的Observer接口来实现一个观察者
 *
 * @author zengxianxi
 * @since 13-9-22 下午2:32
 */
public class MyObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        int[] sum =  ((int[]) arg);
        sum[0]++;
    }

}
