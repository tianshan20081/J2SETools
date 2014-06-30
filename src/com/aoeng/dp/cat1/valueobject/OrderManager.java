/**
 * 
 */
package com.aoeng.dp.cat1.valueobject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Jun 23, 2014 2:35:49 PM
 * 
 */
public class OrderManager extends UnicastRemoteObject implements IOrderManager {

	/**
	 * @throws RemoteException
	 */
	protected OrderManager() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7680453065651702724L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.dp.cat1.valueobject.IOrderManager#getOrder(int)
	 */
	@Override
	public Order getOrder(int id) throws RemoteException{
		// TODO Auto-generated method stub
		Order o = new Order();
		o.setClientName("billy");
		o.setNumber(20);
		o.setProductName("desk");
		return o;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.dp.cat1.valueobject.IOrderManager#getClientName(int)
	 */
	@Override
	public String getClientName(int id) throws RemoteException{
		// TODO Auto-generated method stub
		return "billy";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.dp.cat1.valueobject.IOrderManager#getProdName(int)
	 */
	@Override
	public String getProdName(int id) throws RemoteException{
		// TODO Auto-generated method stub
		return "desk";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.dp.cat1.valueobject.IOrderManager#getNumber(int)
	 */
	@Override
	public int getNumber(int id) throws RemoteException{
		// TODO Auto-generated method stub
		return 20;
	}

}
