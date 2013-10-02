package com.xianxi.study.design.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者应用实例
 *
 * @author zengxianxi
 * @since 13-9-22 下午2:40
 */
public class UseObservable {

    public static void main(String[] args) {
        Observable observable = new Observable();
        int[] sum = new int[1];

        Observer obs1 = new MyObserver();
        Observer obs2 = new MyObserver();


        observable.addObserver(obs1);
        observable.addObserver(obs2);
        observable.notifyObservers(sum);

        System.out.println(sum[0]);
    }

}
