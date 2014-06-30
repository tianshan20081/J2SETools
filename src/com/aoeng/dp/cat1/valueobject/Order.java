/**
 * 
 */
package com.aoeng.dp.cat1.valueobject;

import java.io.Serializable;

/**
 * Jun 23, 2014 2:34:46 PM
 * 
 */
public class Order implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2456066233493496839L;
	private int orderId;
	private String clientName;
	private int number;
	private String productName;
	
	
	/**
	 * 
	 */
	public Order() {
		super();
	}
	/**
	 * @param orderId
	 * @param clientName
	 * @param number
	 * @param productName
	 */
	public Order(int orderId, String clientName, int number, String productName) {
		super();
		this.orderId = orderId;
		this.clientName = clientName;
		this.number = number;
		this.productName = productName;
	}
	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", clientName=" + clientName + ", number=" + number + ", productName="
				+ productName + "]";
	}
	
	
}
