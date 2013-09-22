package com.xianxi.study.design.flyweight;

/**
 * 定义生成报表的接口
 *
 * @author zengxianxi
 * @since 13-9-22 上午2:21
 */
public interface ReportManager {

    /**
     * 定义一个生成报表的方法
     *
     * @return
     */
    String createReport();
}
