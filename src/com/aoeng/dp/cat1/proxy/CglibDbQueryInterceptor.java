/**
 * 
 */
package com.aoeng.dp.cat1.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Jun 20, 2014 2:30:58 PM
 * 
 */
public class CglibDbQueryInterceptor implements MethodInterceptor {
	IDBQuery real = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.cglib.proxy.MethodInterceptor#intercept(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], net.sf.cglib.proxy.MethodProxy)
	 */

	public Object intercept(Object arg0, java.lang.reflect.Method arg1, Object[] arg2, MethodProxy arg3)
			throws Throwable {
		// TODO Auto-generated method stub
		if (null == real)
			real = new DBQuery();
		return real.request();
	}

	public static IDBQuery createCglibProxy() {
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(new CglibDbQueryInterceptor());
		enhancer.setInterfaces(new Class[] { IDBQuery.class });

		IDBQuery cglibProxy = (IDBQuery) enhancer.create();

		return cglibProxy;
	}
}