/**
 * 
 */
package com.aoeng.dp.cat1.valueobject;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.junit.Test;

/**
 * Jun 23, 2014 2:31:34 PM
 * 
 */
public class Main {
	public static void main(String[] args) {


		try {
			LocateRegistry.createRegistry(1099);
			IOrderManager userManager = new OrderManager();
			Naming.rebind("OrderManager", userManager);
			System.out.println("OrderManager is ready.");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}


	@Test
	public void client() {
		try {
			IOrderManager userManager = (IOrderManager) Naming.lookup("OrderManager");
			long begin = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++) {
				userManager.getOrder(i);
			}
			System.out.println("getOrder spend:" + (System.currentTimeMillis() - begin));
//			System.out.println(userManager.toString());

			begin = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++) {
				userManager.getClientName(i);
				userManager.getNumber(i);
				userManager.getProdName(i);
			}
			System.out.println("3 Method call spend :" + (System.currentTimeMillis() - begin));
			System.out.println(userManager.getOrder(0).getClientName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
