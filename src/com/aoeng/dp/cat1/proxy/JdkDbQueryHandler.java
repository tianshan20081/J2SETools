/**
 * 
 */
package com.aoeng.dp.cat1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Jun 20, 2014 2:22:36 PM
 * 
 */
public class JdkDbQueryHandler implements InvocationHandler {
	IDBQuery real = null;

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (null == real)
			real = new DBQuery();
		return real.request();
	}

	public static IDBQuery createJdkProxy() {
		IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
				new Class[] { IDBQuery.class }, new JdkDbQueryHandler());
		return jdkProxy;
	}
}