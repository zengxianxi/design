package com.xianxi.study.design.decorator;

/**
 * 包内容处理
 *
 * @author zengxianxi
 * @since 13-9-22 上午11:51
 */
public interface PacketCreator {
    /**
     * 用于处理内容
     *
     * @return
     */
    String handleContent();
}
