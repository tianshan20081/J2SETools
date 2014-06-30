/**
 * 
 */
package com.aoeng.dp.cat1.observers;

import java.util.Vector;

/**
 * Jun 23, 2014 1:54:38 PM
 * 
 */
public class ConreteSubject implements ISubject {

	Vector<IObserver> observers = new Vector<IObserver>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.dp.cat1.observers.ISubject#attach(com.aoeng.dp.cat1.observers.IObserver)
	 */
	@Override
	public void attach(IObserver observer) {
		// TODO Auto-generated method stub
		observers.addElement(observer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.dp.cat1.observers.ISubject#detach(com.aoeng.dp.cat1.observers.IObserver)
	 */
	@Override
	public void detach(IObserver observer) {
		// TODO Auto-generated method stub
		if (null != observers) {
			if (observers.contains(observer)) {
				observers.removeElement(observer);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aoeng.dp.cat1.observers.ISubject#inform()
	 */
	@Override
	public void inform() {
		// TODO Auto-generated method stub
		Event env = new Event();
		for (IObserver obs : observers) {
			obs.update(env);
		}
	}

}
