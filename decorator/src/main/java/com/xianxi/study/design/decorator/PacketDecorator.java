package com.xianxi.study.design.decorator;

/**
 * 定义装饰者的基类
 *
 * @author zengxianxi
 * @since 13-9-22 上午11:56
 */
public abstract class PacketDecorator implements PacketCreator {
    PacketCreator component;

    protected PacketDecorator(PacketCreator component) {
        this.component = component;
    }


}
