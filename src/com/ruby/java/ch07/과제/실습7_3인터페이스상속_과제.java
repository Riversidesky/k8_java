package com.ruby.java.ch07.과제;

//Discountable 인터페이스 정의
interface Discountable {
	double getDiscountedPrice(double price);
}

//SeasonalDiscount 클래스: Discountable 인터페이스 구현
class SeasonalDiscount implements Discountable {
	private double discountRate;

	public SeasonalDiscount(double discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public double getDiscountedPrice(double price) {
		return price * discountRate;
	}
}

//Item 추상 클래스
abstract class Item3 {
	private String name;    // 제품명
	private double price;   // 제품 가격
	private int stockQuantity; // 재고량
	
	public Item3(String name, int price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
}

//Electronics 클래스: Item 클래스 상속
class Electronics3 extends Item3 {
	int madeYear;
	public Electronics3(String name, int price, int stockQuantity, int madeYear) {
		super(name, price, stockQuantity);
		this.madeYear = madeYear;
	}

}

//Clothing 클래스: Item 클래스 상속
class Clothing3 extends Item3 {
	int size;
	public Clothing3(String name, int price, int stockQuantity, int size) {
		super(name, price, stockQuantity);
		this.size = size;
	}

}


//Order 클래스
class Order3 extends SeasonalDiscount{
	private final int N = 20;
	private Customer3 customer; // 고객명
	private Item3[] items;      // 주문 제품들
	private int[] quantities;  // 주문 제품 수량들
	private String[] orderDates; // 주문일자들 
	private int count;


	public Order3(Customer3 c)  {//Order3(Customer3 c, int capacity, double discountRate) 로 수정하여 main()에서 초기 값을 설정
		super(0.2); // 생성자는 무조건 필드변수를 초기화 해줘야함
		this.customer = c;
		items = new Item3[N];
		quantities = new int[N];
		orderDates = new String[N];
		count = 0;
	}

	public void addItem(Item3 item, int quantity, String date) {
		items[count] = item;
		quantities[count] = quantity;
		orderDates[count] = date;
		count++;
	}

	public double calculateTotal() {
		double total = 0;
		for(int i=0; i < count; i++) {
			total += items[i].getPrice() * quantities[i];
		}
		return total;
	}

	public void printOrderSummary() {
		System.out.println("고객: "+customer.getName());
		for(int i=0; i < count; i++) {
			System.out.println("- "+items[i].getName()+" x "+quantities[i]+": W"+items[i].getPrice());
		}

	}
	// 할인된 내역을 출력하는 메소드
  public void printDiscountDetails() {
	  System.out.println("할인 내역:");
	  double tp = 0.0;
	  for(int i=0; i < count; i++) {
		  System.out.print("- "+items[i].getName()+":원래 가격 W"+items[i].getPrice()+",");
		  System.out.println("시즌할인금액 W"+getDiscountedPrice(items[i].getPrice())+" 고객할인금액 W"+customer.applyDiscount(items[i].getPrice())+
				  ", 할인 후 가격 W"+(items[i].getPrice() - getDiscountedPrice(items[i].getPrice()) - customer.applyDiscount(items[i].getPrice())));
		  tp += (items[i].getPrice() - getDiscountedPrice(items[i].getPrice()) - customer.applyDiscount(items[i].getPrice()))*quantities[i];
	  }
	  
	  System.out.println("할인되어 지불해야 하는 금액 = "+tp);
  }
}

//Customer 추상 클래스 정의
abstract class Customer3 {
	private String name;

	public Customer3(String name) {
		this.name = name;
	}

	abstract double applyDiscount(double totalAmount);
	
	public String getName() {
		return name;
	}
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer3 extends Customer3 {
	static final double REGULARDISCOUNT_RATE = 0.03;
	
	public RegularCustomer3(String name) {
		super(name);
	}

	@Override
	double applyDiscount(double totalAmount) {
		double totalPrice = 0.0;
		totalPrice = totalAmount * REGULARDISCOUNT_RATE;
		return totalPrice;
	}
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer3 extends Customer3 {
	static final double PREMIUMDISCOUNT_RATE = 0.1;
	
	public PremiumCustomer3(String name) {
		super(name);
	}

	@Override
	double applyDiscount(double totalAmount) {
		double totalPrice = 0.0;
		totalPrice = totalAmount * PREMIUMDISCOUNT_RATE;
		return totalPrice;
	}
}
class 실습7_3인터페이스상속_과제 {
	public static void main(String[] args) {
		// 배열에 전자제품과 의류패션 객체 추가
		Item3 note = new Electronics3("노트북", 1500, 24, 23);
		Item3 clothe = new Clothing3("티셔츠", 50, 50, 95);

		// 고객 생성 
		Customer3 regularCustomer = new RegularCustomer3("홍길동");
		Customer3 premiumCustomer = new PremiumCustomer3("강감찬");

		// 주문 생성 및 계산 (RegularCustomer)
		Order3 regularOrder = new Order3(regularCustomer);
		regularOrder.addItem(note, 1, "240901");
		regularOrder.addItem(clothe, 2, "240902");

		regularOrder.printOrderSummary();
		regularOrder.printDiscountDetails();  // 할인된 내역 출력
		
		// 주문 생성 및 계산 (PremiumCustomer)
		Order3 premiumOrder = new Order3(premiumCustomer);
		premiumOrder.addItem(note, 1, "240901");
		premiumOrder.addItem(clothe, 2, "240903");

		premiumOrder.printOrderSummary();
		premiumOrder.printDiscountDetails();  // 할인된 내역 출력
	}
}