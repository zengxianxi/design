package com.xianxi.study.design.decorator;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author zengxianxi
 * @since 13-9-22 下午1:11
 */
public class PacketCreatorTest {
    @Test
    public void testHandleContent() throws Exception {
        PacketCreator packetCreator = new PacketHTTPCreator(new PacketHTMLCreator(new PacketBodyCreator()));

        String content = packetCreator.handleContent();
        String expected = "Cache-Control:no-cache\n" +
                "Sun Sep 22 13:18:37 CST 2013\n" +
                "<html><head></head><body>Body Content of Packet</body></html>";
        Assert.assertEquals("内容错误", expected, content);
    }
}
