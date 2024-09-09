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
	
	public double getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
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

		public Customer2(String name, String city, int age) {
			cname = name;
			this.city = city;
			this.age = age;
		}

		abstract double applyDiscount(double totalAmount);
		
		@Override
		public String toString() {
			return cname+", City : "+city+", age : "+age;
		}
	}

	//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer extends Customer2 {
		static final double REGULARDISCOUNT_RATE = 0.03;
	
		public RegularCustomer(String name, String city, int age) {
			super(name, city, age);
		}

		@Override
		double applyDiscount(double totalAmount) {
			double total = totalAmount * REGULARDISCOUNT_RATE;
			return total;
		}



	}

	//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer extends Customer2 {
		static final double PREMIUMDISCOUNT_RATE = 0.1;
		
		public PremiumCustomer(String name, String city, int age) {
			super(name, city, age);
		}

		@Override
		double applyDiscount(double totalAmount) {
			double total = totalAmount * PREMIUMDISCOUNT_RATE;
			return total;
		}

	}


	//Order 클래스
class Order2 {
		private Customer2 customer; //고객
		private Item2[] items; //제품들
		private int[] quantities; //주문제품수량
		private int itemCount;

		/*
		 * Order2(),addItem()
		 * calculateTotal(),calculateDiscountedTotal(), printOrderSummary()
		 */
		
		public Order2(Customer2 c, int maxIndex) {
			this.customer = c;
			items = new Item2[maxIndex];
			quantities = new int[maxIndex];
			itemCount = 0;
		}
		public void addItem(Item2 item, int i) {
			items[itemCount] = item;
			quantities[itemCount] = i;
			itemCount++;
		}
		public double calculateTotal() {
			double totalA = 0;
			for(int i = 0; i < itemCount; i++) {
				totalA += items[i].getPrice()*quantities[i];
			}
			return totalA;
		}
		public double calculateDiscountedTotal() {
			double totalA = 0;
			for(int i = 0; i < itemCount; i++) {
				double price1 = items[i].getPrice();
				double price2 = customer.applyDiscount(price1);
				totalA += price2*quantities[i];
			}
			return totalA;
		}
		public void printOrderSummary() {
			System.out.println("Order Summary for Customer : "+customer.toString());
			System.out.println("-".repeat(20));
			System.out.println("Item"+"\t"+"Quantity"+" "+"price");
			System.out.println("-".repeat(20));
			for(int i = 0; i < itemCount; i++) {
				System.out.println(items[i].getName()+"\t"+quantities[i]+"\t "+items[i].getPrice()*quantities[i]);
			}
			System.out.println("-".repeat(20));
			System.out.println("Total : "+(calculateTotal()-calculateDiscountedTotal()));
			System.out.println("Discounted Total : "+calculateDiscountedTotal());
			System.out.println("-".repeat(20));
		}

	
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