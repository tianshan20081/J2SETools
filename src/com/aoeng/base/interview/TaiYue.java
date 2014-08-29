package com.aoeng.base.interview;

public class TaiYue {
	public static void main(String[] args) {
		Child ch = new Child();
		// System.out.println(ch.getName());
		System.out.println(((Father) ch).getName());
		System.out.println(((Person) ch).getName());
	}

}

abstract class Person {
	public Person() {
		// TODO Auto-generated constructor stub

		System.out.println("new Person()");
	}

	public String m_name = "GodClass";

	public String getName() {
		System.out.println("new Person() getName()");
		return m_name;
	}
}

class Father extends Person {
	public Father() {
		// TODO Auto-generated constructor stub
		System.out.println("new Father()");
	}

	public String m_name = "FatherClass";

	public String getName() {
		System.out.println("new Father() getName()");
		return super.m_name;
	}
}

class Child extends Father {
	public Child() {
		// TODO Auto-generated constructor stub
		System.out.println("new Child()");
	}

	public String getName() {
		System.out.println("new Child() getName()");
		return m_name;
	}

	public String getSon() {
		return "Son";
	}
}
