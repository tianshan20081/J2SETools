/**
 * 
 */
package com.aoeng.dp.cat1.decorator;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

/**
 * Jun 23, 2014 11:33:56 AM
 * 
 * 装饰者模式：它可以动态添加对象。通过委托机制，复用系统中的各个组件，在运行时，可以讲这些功能组件进行叠加，
 * 从而构造一个“超级对象”，使其拥有所有这些组件的功能。各个子功能模块，被很好的维护在各个组件的相关类中， 拥有整洁的系统结构。
 */
public class Main {

	public static void main(String[] args) {

		IPacketCreator creator = new PackHTTPHeaderCreator(
				new PacketHTMLHeaderCreator(new PacketBodyCreator()));

		System.out.println(creator.handleContent());
	}

	@Test
	public void testOutputStream() throws Exception {
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream("a.txt")));
		DataOutputStream dos2 = new DataOutputStream(new FileOutputStream(
				"b.txt"));
		int n = 1000;
		long begin = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			dos.writeLong(i);
		}
		System.out.println(System.currentTimeMillis() - begin);
		begin = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			dos2.writeLong(i);
		}
		System.out.println(System.currentTimeMillis() - begin);
	}
}
