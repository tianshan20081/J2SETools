/**
 * 
 */
package com.aoeng.dp.cat1.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Jun 20, 2014 4:33:12 PM
 * 
 */
public class ReportManagerFactory {

	Map<String, IReportManager> financialManager = new HashMap<String, IReportManager>();
	Map<String, IReportManager> employeeManager = new HashMap<String, IReportManager>();

	IReportManager getFinancialIReportManager(String tenantId) {
		IReportManager ir = financialManager.get(tenantId);
		if (null == ir) {
			ir = new FinancialReportManager(tenantId);
			financialManager.put(tenantId, ir);
		}
		return ir;
	}

	IReportManager getEmployeeIReportManager(String tenantId) {
		IReportManager ir = employeeManager.get(tenantId);
		if (null == ir) {
			ir = new EmployeeReportManager(tenantId);
			employeeManager.put(tenantId, ir);
		}
		return ir;
	}

}
