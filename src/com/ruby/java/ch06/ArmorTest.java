package com.ruby.java.ch06;

public class ArmorTest {

	public static void main(String[] args) {
		Armor suit1 = new Armor();
		Armor suit2 = new Armor();
		Armor suit3 = new Armor();
		
		suit1.setName("mark6");
		suit1.setHeight(180);
		
		suit2.setName("mark16");
		suit2.setHeight(220);
		
		suit3.setName("mark38");
		suit3.setHeight(200);
		
		String n1 = suit1.getName();
		int h1 = suit1.getHeight();
		
		System.out.println(suit1.getName() + " : " + suit1.getHeight());
		System.out.println(n1 + " : " + h1);
		System.out.println(suit2.getName() + " : " + suit2.getHeight());
		System.out.println(suit3.getName() + " : " + suit3.getHeight());
		
		test();
			
	}

	private static void test() {
		Armor suit10 = new Armor();
		Armor suit20= new Armor();
		Armor suit30 = new Armor();
		
		suit10.setName("mark600");
		suit10.setHeight(180);
		
		suit20.setName("mark1600");
		suit20.setHeight(220);
		
		suit30.setName("mark3800");
		suit30.setHeight(200);
		
		String n1 = suit10.getName();
		int h1 = suit10.getHeight();
		
		System.out.println(suit10.getName() + " : " + suit10.getHeight());
		System.out.println(n1 + " : " + h1);
		System.out.println(suit20.getName() + " : " + suit20.getHeight());
		System.out.println(suit30.getName() + " : " + suit30.getHeight());
		
	}

}
