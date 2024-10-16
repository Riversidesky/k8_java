package com.ruby.java.ch06;

public class StaticMethodTest {
	//static 
	int num = 123;
	public static void main(String[] args) {
		StaticMethodTest.print1();
		StaticMethodTest s = new StaticMethodTest(); // static이 없는 메소드는 참조변수 필요 main함수 전에 실행안돼서
		s.print2("!");
	}
	

	public static void print1() {
		//int num2 = num;
		System.out.println("hello");
		
	}
	
	public void print2(String t) { // static이 없는 메소드는 참조변수 필요 main함수 전에 실행안돼서
		//int num3 = num;
		System.out.println("java" + t);
	}
}
