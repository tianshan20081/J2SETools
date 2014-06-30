/**
 * 
 */
package com.aoeng.dp.cat1.proxy;

/**
 * Jun 20, 2014 1:05:37 PM
 * 
 */
public class DBQuery implements IDBQuery {

	public DBQuery() {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.dp.cat1.proxy.IDBQuery#request()
	 */
	@Override
	public String request() {
		// TODO Auto-generated method stub
		return " DBQuery String";
	}

}
