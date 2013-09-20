package com.xianxi.study.design;

/**
 * 定义一个单例模式的类
 *
 * @author zengxianxi
 * @since 13-9-20 下午4:29
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }
}
