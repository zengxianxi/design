package com.xianxi.study.design.decorator;

/**
 * HTTP的装饰者
 * @author zengxianxi
 * @since 13-9-22 下午12:03
 */
public class PacketHTTPCreator extends PacketDecorator{

    protected PacketHTTPCreator(PacketCreator component) {
       super(component);
    }

    @Override
    public String handleContent() {
        StringBuffer sb = new StringBuffer();
        sb.append("Cache-Control:no-cache\n")
                .append("Sun Sep 22 13:18:37 CST 2013")
                .append("\n")
                .append(component.handleContent());
        return sb.toString();
    }
}
