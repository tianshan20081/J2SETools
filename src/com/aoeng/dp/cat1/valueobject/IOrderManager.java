/**
 * 
 */
package com.aoeng.dp.cat1.valueobject;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Jun 23, 2014  2:32:51 PM
 *
 */
public interface IOrderManager extends Remote {
	public Order getOrder(int id) throws RemoteException;
	public String getClientName(int id) throws RemoteException;
	public String getProdName(int id) throws RemoteException;
	public int getNumber(int id) throws RemoteException;
}
