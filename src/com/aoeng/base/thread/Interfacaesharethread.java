package com.aoeng.base.thread;

/**
 * 通过实现Runnable接口实现线程的共享变量
 * 
 * @author Administrator
 * 
 */
public class Interfacaesharethread {
	public static void main(String[] args) {
		Mythread2 mythread = new Mythread2();
		new Thread(mythread).start();
		new Thread(mythread).start();
		new Thread(mythread).start();
		new Thread(mythread).start();
	}
}

/* 实现Runnable接口 */
class Mythread2 implements Runnable {
	int index = 0;

	public synchronized void run() {
		while (true)
			System.out.println(Thread.currentThread().getName() + "is running and the index is " + index++);
	}
}