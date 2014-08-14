/**
 * 
 */
package com.aoeng.dp.cat1.flyweight;

import org.junit.Test;

/**
 * Jun 20, 2014 4:41:49 PM
 * 
 * 享元模式 ：如果在一个系统中存在多个相同的对象，那么只需共享一份对象的拷贝，
 * 而不必为每一次使都创建新的对象。
 */
public class Main {

	@Test
	public void testFlyWeight() {
		ReportManagerFactory factory = new ReportManagerFactory();
		IReportManager rp = factory.getFinancialIReportManager("A");
		System.out.println(rp);
	}

}
