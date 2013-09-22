package com.xianxi.study.design.decorator;

/**
 * 主体部分内容的创建器
 *
 * @author zengxianxi
 * @since 13-9-22 上午11:52
 */
public class PacketBodyCreator implements PacketCreator {
    /**
     * 核造主体的数据内容
     *
     * @return
     */
    @Override
    public String handleContent() {
        return "Body Content of Packet";
    }
}
