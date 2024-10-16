package com.ruby.java.ch14;

interface MyInterface {
	public void print();
}

class MyClass1 implements MyInterface {
	@Override
	public void print() {
		System.out.println("MyClass1");
	}
}

class MyClass2 implements MyInterface {
	@Override
	public void print() {
		System.out.println("MyClass2");
	}
}

public class Test01 {
	static void test(MyInterface m) {
		m.print();
	}
	static MyInterface test2() {
		MyInterface mi = new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명클래스");
			}
		};
		return mi;
	}
	static MyInterface test3() {
		return new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명클래스3");
			}
		};
	}
	
	public static void main(String[] args) {
		MyClass1 mc1 = new MyClass1();
		MyClass2 mc2 = new MyClass2();
		mc1.print();
		test(mc1);
		mc2.print();
		test(mc2);
		
		MyInterface mi = new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명클래스");
			}
		};
		mi.print();
		
		new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명클래스2");
			}
		}.print();
		
		MyInterface mi2 = test2();
		mi2.print();
		
		MyInterface mi3 = test3();
		mi3.print();
		
		
	}
}
