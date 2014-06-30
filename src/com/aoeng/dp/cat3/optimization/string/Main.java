/**
 * 
 */
package com.aoeng.dp.cat3.optimization.string;

import org.junit.Test;

/**
 * Jun 24, 2014  2:00:13 PM
 *
 */
public class Main {
	
	public static void main(String[] args) {
		String string = "";
	}
	
	@Test
	public void normal(){
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		System.out.println("str1 == str2\t"+(str1 == str2));
		System.out.println("str1 == str3\t"+(str1 == str3));
		System.out.println("str1 == str3.intern()\t"+(str1 == str3.intern()));
		
		
		
		
		
		
		
	}

}
