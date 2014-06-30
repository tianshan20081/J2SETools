/**
 * 
 */
package com.aoeng.dp.cat1.flyweight;

import org.junit.Test;

/**
 * Jun 20, 2014 4:41:49 PM
 * 
 */
public class Main {

	@Test
	public void testFlyWeight() {
		ReportManagerFactory factory = new ReportManagerFactory();
		IReportManager rp = factory.getFinancialIReportManager("A");
		System.out.println(rp);
	}

}
