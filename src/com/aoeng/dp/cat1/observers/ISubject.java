/**
 * 
 */
package com.aoeng.dp.cat1.observers;

/**
 * Jun 23, 2014 1:42:49 PM
 * 
 */
public interface ISubject {
	void attach(IObserver observer);

	void detach(IObserver observer);

	void inform();
}
