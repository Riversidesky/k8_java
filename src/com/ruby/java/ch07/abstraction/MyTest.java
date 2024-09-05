package com.ruby.java.ch07.abstraction;

//interface GPI {
//	void test();
//}

class GrandParents { //implements GPI {
	public void test() {
		System.out.println("GP - test  1");
	}
}

class Parents extends GrandParents {
	public void test() {
		System.out.println("PP - test  2");
	}
	public void test1() {
		System.out.println("PP - test1  3");
	}
}

class Child extends Parents {
	public void test() {
		System.out.println("CD - test  4");
	}
	public void test1() {
		System.out.println("CD - test1  5");
	}
	public void test2() {
		System.out.println("CD - test2  6");
	}
}

public class MyTest {
	public static void main(String[] args) {
		Child obj = new Child();
		obj.test();
		obj.test1();
		obj.test2();
		System.out.println("-".repeat(10));
		
		Parents c = new Child();
		c.test();
		c.test1(); //2,3이 아니라 4,5가 실행이됨
//		c.test2(); //인스턴스(붕어빵틀) 존재 x => test2함수 넣을데가없음
		
		//print(obj);
	}

//	private static void print(Child obj) {
//	private static void print(Parents obj) {
//	private static void print(GrandParents obj) {
//		
//		obj.test();
//	
//	}
}
