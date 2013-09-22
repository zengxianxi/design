package com.xianxi.study.design.decorator;

/**
 * HTML格式的装饰者
 *
 * @author zengxianxi
 * @since 13-9-22 上午11:59
 */
public class PacketHTMLCreator extends PacketDecorator {

    protected PacketHTMLCreator(PacketCreator component) {
        super(component);
    }

    @Override
    public String handleContent() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html><head></head><body>")
                .append(component.handleContent())
                .append("</body></html>");
        return sb.toString();
    }
}
