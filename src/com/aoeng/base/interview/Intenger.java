package com.aoeng.base.interview;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class Intenger {
	public static void main(String[] args) {

	}

	@Test
	public void testAtomicInteger() {
		AtomicInteger atomicInteger = new AtomicInteger();
		atomicInteger.addAndGet(1);
		System.out.println(atomicInteger);
	}
	@Test
	public void testAtomicInteger2() {
		AtomicInteger atomicInteger = new AtomicInteger();
		for (int i = 0; i < 10; i++) {
			atomicInteger.addAndGet(1);
		}
		
		System.out.println(atomicInteger);
	}

	@Test
	public void testInt() {
		int i = 0;
		for (int j = 0; j < 10; j++) {
			i = i++;
		}
		System.out.println(i);
	}
	@Test
	public void testInt2() {
		int i = 0;
		for (int j = 0; j < 10; j++) {
			i = ++i;
		}
		System.out.println(i);
	}

}
