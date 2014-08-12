/**
 * 
 */
package com.aoeng.dp.cat1.singleton;

/**
 * Jun 20, 2014  11:49:52 AM
 *
 */
public class StaticSingelton {

	private StaticSingelton(){
		System.out.println("StaticSingleton is create ");
		
	}
	private static class StaticHolder{
		private static StaticSingelton singelton = new StaticSingelton();
	}
	public static StaticSingelton getInstance(){
		return StaticHolder.singelton;
	}
}
