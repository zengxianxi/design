package com.xianxi.study.design.flyweight;

/**
 * 定义一个财务报表生成类
 *
 * @author zengxianxi
 * @since 13-9-22 上午2:24
 */
public class FinancialReportManager implements ReportManager {
    protected String tenantId;

    public FinancialReportManager(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "This is a financial report";
    }
}
