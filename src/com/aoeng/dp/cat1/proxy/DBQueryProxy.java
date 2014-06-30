/**
 * 
 */
package com.aoeng.dp.cat1.proxy;

/**
 * Jun 20, 2014 1:07:04 PM
 * 
 */
public class DBQueryProxy implements IDBQuery {

	private IDBQuery query;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.dp.cat1.proxy.IDBQuery#request()
	 */
	@Override
	public String request() {
		// TODO Auto-generated method stub
		if (null == query) {
			query = new DBQuery();
		}
		return query.request();
	}

}
