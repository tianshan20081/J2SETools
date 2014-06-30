/**
 * 
 */
package com.aoeng.dp.cat1.observers;

/**
 * Jun 23, 2014 2:14:04 PM
 * 
 */
public class OnLongClickListener implements IObserver {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.dp.cat1.observers.IObserver#update(com.aoeng.dp.cat1.observers.Event)
	 */
	@Override
	public void update(Event env) {
		// TODO Auto-generated method stub
		System.out.println("OnLongClickListener " + env.onLongClick());
	}

}
