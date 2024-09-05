package com.ruby.java.ch07.inheritance;

class DD {
	String name;
	
	public DD(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) { // 안의 값 비교
		DD d = (DD)obj;
		if (name.equals(d.name)) {
			return true;
		}
		
		return false;
	}
}

public class EqualTest {
	public static void main(String[] args) {
		DD a = new DD("A");
		DD b = new DD("B");
		DD c = new DD("A");
		
		DD d = a;
		
		System.out.println((a==b)?"equal":"not equal"); // 주소를 비교
		System.out.println((a==c)?"equal":"not equal");
		System.out.println((a==d)?"equal":"not equal");
		
		System.out.println((a.equals(c))?"equal":"not equal");
	}
}
