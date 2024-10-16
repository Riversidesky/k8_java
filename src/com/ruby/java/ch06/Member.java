package com.ruby.java.ch06;

public class Member {
	private String name;
	private int age;

	public Member() { // ctrl + shift + s 제네레이트 컨스터럭터 유징 필드 //메소드 이름은 대문자로 시작되지않는다.
		this("guest"); // 스트링 하나들어가는 생성자 호출
	}
	public Member(String name) {
		this(name, 1);
	}		
	public Member(String name, int age) { 
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return name + ":" + age;
	}

	public static void main(String[] args) {
		Member m1 = new Member();
		Member m2 = new Member("Amy");
		Member m3 = new Member("Amy", 23);
		
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
	}

}
