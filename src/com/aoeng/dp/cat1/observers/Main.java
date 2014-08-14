/**
 * 
 */
package com.aoeng.dp.cat1.observers;

/**
 * Jun 23, 2014 1:42:31 PM
 * 
 * 观察者模式
 */
public class Main {

	public static void main(String[] args) {
		ConreteSubject subject = new ConreteSubject();
		OnClickListener l1 = new OnClickListener();
		subject.attach(l1);
		subject.attach(new OnLongClickListener());
		subject.inform();
		subject.detach(l1);
		subject.inform();

	}

}
