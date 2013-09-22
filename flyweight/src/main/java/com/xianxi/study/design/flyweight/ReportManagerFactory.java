package com.xianxi.study.design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 定义一个报表工厂
 *
 * @author zengxianxi
 * @since 13-9-22 上午2:36
 */
public class ReportManagerFactory {

    private Map<String, ReportManager> financialReportManager = new HashMap<String, ReportManager>();
    private Map<String, ReportManager> employeeReportManager = new HashMap<String, ReportManager>();

    /**
     * 通过租户ID获取财务报表对象
     *
     * @param tenantId
     * @return
     */
    public ReportManager getFinancialReportManager(String tenantId) {
        ReportManager reportManager = financialReportManager.get(tenantId);
        if (reportManager == null) {
            reportManager = new FinancialReportManager(tenantId);
            financialReportManager.put(tenantId, reportManager);
        }
        return reportManager;
    }

    /**
     * 通过租户ID获取员工报表对象
     *
     * @param tenantId
     * @return
     */
    public ReportManager getEmployeeReportManager(String tenantId) {
        ReportManager reportManager = employeeReportManager.get(tenantId);
        if (reportManager == null) {
            reportManager = new EmployeeReportManager(tenantId);
            employeeReportManager.put(tenantId, reportManager);
        }
        return reportManager;
    }


}
