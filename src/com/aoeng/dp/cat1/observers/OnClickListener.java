/**
 * 
 */
package com.aoeng.dp.cat1.observers;

/**
 * Jun 23, 2014  2:12:27 PM
 *
 */
public class OnClickListener implements IObserver {

	/* (non-Javadoc)
	 * @see com.aoeng.dp.cat1.observers.IObserver#update(com.aoeng.dp.cat1.observers.Event)
	 */
	@Override
	public void update(Event env) {
		// TODO Auto-generated method stub
		System.out.println("onclick"+env.click());
	}

}
