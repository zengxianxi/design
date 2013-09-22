package com.xianxi.study.design.flyweight;

/**
 * 定义一个员工报表生成类
 * @author zengxianxi
 * @since 13-9-22 上午2:29
 */
public class EmployeeReportManager implements ReportManager {

    protected String tenantId;

    public EmployeeReportManager(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "This is a employee report";
    }
}
