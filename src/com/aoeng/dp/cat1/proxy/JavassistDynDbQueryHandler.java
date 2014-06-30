/**
 * 
 */
package com.aoeng.dp.cat1.proxy;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

/**
 * Jun 20, 2014 3:10:52 PM
 * 
 */
public class JavassistDynDbQueryHandler implements MethodHandler {
	IDBQuery real = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javassist.util.proxy.MethodHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object arg0, Method arg1, Method arg2, Object[] arg3) throws Throwable {
		// TODO Auto-generated method stub
		if (null == real) {
			real = new DBQuery();
		}
		return real.request();
	}

	public static IDBQuery createJavassistDynProxy() throws Exception {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setInterfaces(new Class[] { IDBQuery.class });
		Class proxyClass = proxyFactory.createClass();
		IDBQuery javassistProxy = (IDBQuery) proxyClass.newInstance();
		((ProxyObject) javassistProxy).setHandler(new JavassistDynDbQueryHandler());
		return javassistProxy;
	}

	public static IDBQuery createJavassistBytecodeDynamicProxy() throws Exception {
		ClassPool mPool = new ClassPool(true);
		// 定义类名
		CtClass mCtc = mPool.makeClass(IDBQuery.class.getName() + "javassistBytecodeDynamicProxy");
		// 需要实现的接口
		mCtc.addInterface(mPool.get(IDBQuery.class.getName()));
		// 添加构造函数
		mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
		// 添加类的字段信息,使用动态 Java 代码
		mCtc.addField(CtField.make("public " + IDBQuery.class.getName() + " real;", mCtc));
		String dbqueryname = DBQuery.class.getName();
		// 添加方法,这里使用动态 Java 代码制定内部逻辑
		// 添加方法,这里使用动态 Java 代码制定内部逻辑
		mCtc.addMethod(CtNewMethod.make("public String request() {if (null == real){ real = new " + dbqueryname
				+ "(); } return real.request() ; }", mCtc));
		// 基于以上信息,生成动态类
		Class pc = mCtc.toClass();
		// 生成动态类的实例
		IDBQuery bytecodeProxy = (IDBQuery) pc.newInstance();
		return bytecodeProxy;

	}
}
