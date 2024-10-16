package com.ruby.java.ch07.abstraction;

abstract class Employee {
	String name;
	int salarey;
	
	public abstract void calcSalary(); // 함수 바디가 없으면 추상메소드, 추상메소드는 리턴값앞에 abstract를 쓰는데 클래스앞에도 붙어야함
	public abstract void calcBonus(); 
	
	@Override
	public String toString() {
		return name+":"+salarey;
	}

}

class Salesman extends Employee {
	int annual_sales;
	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");
	}

	@Override
	public void calcBonus() {
		System.out.println("Salesman 보너스 = 기본급 *12 + 4");
	}
}
class Consultant extends Employee {
	int num_project;
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 컨설팅 특별 수당");
	}

	@Override
	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급 * 12 * 2");
	}
	
}

class Manager extends Employee {
	int num_team;
	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
		
	}

	@Override
	public void calcBonus() {
		System.out.println("Manager 보너스 = 기본급 * 12 * 6");
		
	}
	
}

class Director extends Manager {

	@Override
	public void calcBonus() {
		System.out.println("Director 보너스 = 기본급 * 12 * 6");
	}
	
}

public class HRSTest {
	public static void calcTax(Employee e) {
		System.out.println("소득세를 계산합니다.");
	}
	public static void main(String[] args) {
//		Employee e = new Employee(); // 추상클래스는 인스턴스 못만듬
		Salesman s = new Salesman();
		Consultant c = new Consultant();
//		Manager m = new Manager(); //추상클래스는 인스턴스 못만듬
		Director d = new Director();
		
		Salesman s1 = new Salesman();
		Employee s2 = new Salesman();
		Object s3 = new Salesman();
		
		Object m1 = new Manager();
		Employee m2 = new Manager();
		Manager m3 = new Manager();
		
		Object arr[] = new Object[6];
		arr[0] = s1;
		arr[1] = s2;
		arr[2] = s3;
		arr[3] = m1;
		arr[4] = m2;
		arr[5] = m3;
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i].toString());
		}
		
		
//		s.calcSalary();
//		c.calcSalary();
//		m.calcSalary();
		
//		s.calcBonus();
//		c.calcBonus();
//		d.calcBonus();

//		System.out.println(s.toString());
//		System.out.println(c.toString());
//		System.out.println(d.toString());
//		
//		if (s.equals(c) ) {
//			System.out.println("같은 객체");
//		}
//		else {
//			System.out.println("다른 객체");
//		}
//		
//		calcTax(s);
//		calcTax(c);
//		calcTax(d);
	}
}

