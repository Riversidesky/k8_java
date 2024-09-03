package com.ruby.java.ch07.abstraction;

abstract class Employee {
	String name;
	int salarey;
	
	public abstract void calcSalary(); // 함수 바디가 없으면 추상메소드, 추상메소드는 리턴값앞에 abstract를 쓰는데 클래스앞에도 붙어야함
	public abstract void calcBonus(); 

}

class Salesman extends Employee {
	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");
	}

	@Override
	public void calcBonus() {
		System.out.println("Salesman 보너스 = 기본급 *12 + 4");
	}
}
class Consultant extends Employee {
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 컨설팅 특별 수당");
	}

	@Override
	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급 * 12 * 2");
	}
	
}

abstract class Manager extends Employee {
	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
		
	}
	
}

class Director extends Manager {

	@Override
	public void calcBonus() {
		System.out.println("Director 보너스 = 기본급 * 12 * 6");
	}
	
}

public class HRSTest {
	public static void main(String[] args) {
//		Employee e = new Employee(); // 추상클래스는 인스턴스 못만듬
		Salesman s = new Salesman();
		Consultant c = new Consultant();
//		Manager m = new Manager(); //추상클래스는 인스턴스 못만듬
		Director d = new Director();
		
//		s.calcSalary();
//		c.calcSalary();
//		m.calcSalary();
		
		s.calcBonus();
		c.calcBonus();
		d.calcBonus();
	}
}

