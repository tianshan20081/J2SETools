/**
 * 
 */
package com.aoeng.dp.cat1.proxy;

import org.junit.Test;

/**
 * Jun 20, 2014 1:08:34 PM
 * 
 * 动态代理模式
 */
public class Main {
	public static final int CIRCLE = 300000000;

	public static void main(String args[]) throws Exception {
		IDBQuery d = null;
		long begin = System.currentTimeMillis();
		d = JdkDbQueryHandler.createJdkProxy();
		System.out.println("createjdkProxy:\t"
				+ (System.currentTimeMillis() - begin));
		System.out.println("JdkProxy class:\t" + d.getClass().getName());
		begin = System.currentTimeMillis() - begin;
		for (int i = 0; i < CIRCLE; i++) {
			d.request();
		}
		System.out.println("callJdkProxy:\t"
				+ (System.currentTimeMillis() - begin));
		System.out.println("\n");
		begin = System.currentTimeMillis() - begin;
		d = CglibDbQueryInterceptor.createCglibProxy();
		System.out.println("createCglibProxy :\t"
				+ (System.currentTimeMillis() - begin));
		System.out.println("CglibProxy : class:\t" + d.getClass().getName());
		begin = System.currentTimeMillis() - begin;
		for (int i = 0; i < CIRCLE; i++) {
			d.request();
		}
		System.out.println("callCglibProxy:\t"
				+ (System.currentTimeMillis() - begin));
		System.out.println("\n");
		begin = System.currentTimeMillis() - begin;
		d = JavassistDynDbQueryHandler.createJavassistDynProxy();
		System.out.println("createJavassistProxy :\t"
				+ (System.currentTimeMillis() - begin));
		System.out
				.println("JavassistProxy : class:\t" + d.getClass().getName());
		begin = System.currentTimeMillis() - begin;
		for (int i = 0; i < CIRCLE; i++) {
			d.request();
		}
		System.out.println("callJavassistDyn:\t"
				+ (System.currentTimeMillis() - begin));
		System.out.println("\n");
		begin = System.currentTimeMillis() - begin;
		d = JavassistDynDbQueryHandler.createJavassistBytecodeDynamicProxy();
		System.out.println("createJavassistBytecodeDynamicProxy :\t"
				+ (System.currentTimeMillis() - begin));
		System.out.println("JavassistBytecodeDynamicProxy : class:\t"
				+ d.getClass().getName());
		begin = System.currentTimeMillis() - begin;
		for (int i = 0; i < CIRCLE; i++) {
			d.request();
		}
		System.out.println("callJavassistDynbytecode:\t"
				+ (System.currentTimeMillis() - begin));
	}

	@Test
	public void testProxy() {

		IDBQuery q = new DBQueryProxy();
		String str = q.request();
		System.out.println(str);
	}

}
