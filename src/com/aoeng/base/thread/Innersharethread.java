package com.aoeng.base.thread;

/**
 * 通过内部类实现线程的共享变量
 * 
 */
public class Innersharethread {
	public static void main(String[] args) {
		Mythread mythread = new Mythread();
		mythread.getThread().start();
		mythread.getThread().start();
		mythread.getThread().start();
		mythread.getThread().start();
	}
}

class Mythread {
	int index = 0;

	private class InnerThread extends Thread {
		public synchronized void run() {
			while (true) {
				System.out.println(Thread.currentThread().getName() + "is running and index is " + index++);
			}
		}
	}

	public Thread getThread() {
		return new InnerThread();
	}
}
