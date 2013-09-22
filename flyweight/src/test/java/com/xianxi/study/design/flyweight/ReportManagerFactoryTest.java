package com.xianxi.study.design.flyweight;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zengxianxi
 * @since 13-9-22 上午2:48
 */
public class ReportManagerFactoryTest {
    private ReportManagerFactory factory;

    @Before
    public void initFactory(){
        factory = new ReportManagerFactory();
    }

    @Test
    public void testGetFinancialReportManager() throws Exception {
        ReportManager reportManager = factory.getFinancialReportManager("com001");
        String report = reportManager.createReport();
        Assert.assertEquals("报表内容错误","This is a financial report",report);
    }

    @Test
    public void testGetEmployeeReportManager() throws Exception {
        ReportManager reportManager = factory.getEmployeeReportManager("com001");
        String report = reportManager.createReport();
        Assert.assertEquals("报表内容错误","This is a employee report",report);
    }
}
