/**
 * 
 */
package com.aoeng.dp.cat1.flyweight;

/**
 * Jun 20, 2014  4:31:29 PM
 *
 */
public class EmployeeReportManager implements IReportManager {
	private String tenantId = null;

	public EmployeeReportManager(String tenantId){
		
		this.tenantId = tenantId ;
	}
	/* (non-Javadoc)
	 * @see com.aoeng.dp.cat1.flyweight.IReportManager#createReport()
	 */
	@Override
	public String createReport() {
		// TODO Auto-generated method stub
		return "This is employee report";
	}

}
