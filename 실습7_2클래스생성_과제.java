package com.ruby.java.ch07.과제;

//Item 클래스
class Item2 {
	private String name;
	private double price;
	private int stockQuantity;
	
	public Item2(String name, double price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
}

	//Electronics 클래스 (Item 클래스를 상속)
class Electronics extends Item2 {
		private int warranty; // 제품 보증 기간

		public Electronics(String name, double price, int stockQuantity, int warranty) {
			super(name, price, stockQuantity);
			this.warranty = warranty;
		}

	}

	//Clothing 클래스 (Item 클래스를 상속)
class Clothing extends Item2 {
		private String size;
		private String color;
		
		public Clothing(String name, double price, int stockQuantity, String size, String color) {
			super(name, price, stockQuantity);
			this.size = size;
			this.color = color;
		}
		
		
		

	}
	//Customer 추상 클래스 정의
abstract class Customer2 {
		private String cname;
		private String city;
		private int age;

		abstract double applyDiscount(double totalAmount);
	}

	//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer extends Customer2 {
		static final double REGULARDISCOUNT_RATE = 0.03;

	}

	//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer extends Customer2 {
		static final double PREMIUMDISCOUNT_RATE = 0.1;
		
		public PremiumCustomer(String name, String city, int age) {
			cname = name;
		}

	}


	//Order 클래스
class Order2 {
		private Customer2 customer;
		private Item2[] items;
		private int[] quantities;
		private int itemCount;
		/*
		 * Order2(),addItem()
		 * calculateTotal(),calculateDiscountedTotal(), printOrderSummary()
		 */
	
	}
public class 실습7_2클래스생성_과제 {
	public static void main(String[] args) {
			// 의류 및 전자제품 생성
			Electronics laptop = new Electronics("노트북", 1200.00, 10, 24);
			Electronics phone = new Electronics("휴대폰", 800.00, 30, 12);
			Clothing tshirt = new Clothing("티셔츠", 20.00, 50, "M", "Blue");
			Clothing jacket = new Clothing("자켓", 80.00, 20, "L", "Black");

			// 고객 생성
			PremiumCustomer premiumCustomer = new PremiumCustomer("홍길동", "부산", 30);
			RegularCustomer regularCustomer = new RegularCustomer("계백", "양산", 25);

			// 주문 생성
			Order2 order1 = new Order2(premiumCustomer, 4);
			order1.addItem(laptop, 1);
			order1.addItem(tshirt, 2);

			Order2 order2 = new Order2(regularCustomer, 4);
			order2.addItem(phone, 1);
			order2.addItem(jacket, 1);

			// 주문 요약 출력
			System.out.println("Premium Customer Order:");
			order1.printOrderSummary();

			System.out.println("Regular Customer Order:");
			order2.printOrderSummary();
		}
	}