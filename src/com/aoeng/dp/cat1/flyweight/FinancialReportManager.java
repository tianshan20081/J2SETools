/**
 * 
 */
package com.aoeng.dp.cat1.flyweight;

/**
 * Jun 20, 2014  4:29:35 PM
 *
 */
public class FinancialReportManager implements IReportManager{
	private String tenantId = null ;
	
	public FinancialReportManager(String tenantId){
		this.tenantId = tenantId ;
	}
	/* (non-Javadoc)
	 * @see com.aoeng.dp.cat1.flyweight.IReportManager#createReport()
	 */
	@Override
	public String createReport() {
		// TODO Auto-generated method stub
		return "This is financial report !";
	}

}
