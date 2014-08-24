package com.aoeng.base.interview.heima;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/*
 ArrayList<Integer> list = new ArrayList<Integer>(); 
 在这个泛型为Integer的ArrayList中存放一个String类型的对象。

 分析：这道题目如果你按照正常的思路肯定是没有办法做的。好在Java提供了发射机制。
 通过反射可以擦除泛型检查。
 */
public class Test9 {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ArrayList<Integer> array = new ArrayList<Integer>();

		// 获取字节码文件对象
		Class<?> c = array.getClass();

		// 获取添加的功能,并制定奖励功能的参数类型是Object
		Method m = c.getMethod("add", Object.class);

		// 通过反射调用功能添加字符串
		m.invoke(array, "hello");
		m.invoke(array, "world");
		m.invoke(array, "itcast");

		// 输出集合
		System.out.println(array);
	}
}
