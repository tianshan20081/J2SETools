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
 */
public class Main {

	public static void main(String[] args) {

		IPacketCreator creator = new PackHTTPHeaderCreator(new PacketHTMLHeaderCreator(new PacketBodyCreator()));

		System.out.println(creator.handleContent());
	}
	
	@Test
	public void testOutputStream() throws Exception{
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("a.txt")));
		DataOutputStream dos2 = new DataOutputStream(new FileOutputStream("b.txt"));
		int n = 10000000;
		long begin = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			dos.writeLong(i);
		}
		System.out.println(System.currentTimeMillis()-begin);
		begin = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			dos2.writeLong(i);
		}
		System.out.println(System.currentTimeMillis()-begin);
	}
}
