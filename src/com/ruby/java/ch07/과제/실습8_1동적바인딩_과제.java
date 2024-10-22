package com.ruby.java.ch07.과제;

//2단계 - 문제 4: 동적바인딩
//Item 추상 클래스
abstract class Item4 {
	private String name;    // 제품명
	private double price;   // 제품 가격
	private int stockQuantity; // 재고량

	public Item4 (String name, double price, int stockQuantity) {
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
	
	public int getQuantity() {
		return stockQuantity;
	}
	
	public void show() {
		
	}

	public void setQuantity(int quantities) {
		stockQuantity -= quantities;
	}
}

//Electronics 클래스: Item 클래스 상속
class Electronics4 extends Item4 {
	int madeYear;
	public Electronics4(String name, double price, int stockQuantity, int madeYear) {
		super(name, price, stockQuantity);
		this.madeYear = madeYear;
	}
	
	public void show() {
		System.out.println("전자제품:"+getName()+" - W"+getPrice()+"재고량:"+getQuantity()+"제조년도:"+madeYear);
	}

}

//Clothing 클래스: Item 클래스 상속
class Clothing4 extends Item4 {
	int size;
	public Clothing4(String name, double price, int stockQuantity, int size) {
		super(name, price, stockQuantity);
		this.size = size;
	}
	
	public void show() {
		System.out.println("의류패션:"+getName()+" - W"+getPrice()+"재고량:"+getQuantity()+"치수:"+size);
	}

}
//Discountable 인터페이스 정의
interface Discountable4 {
	double getDiscountedPrice(double price);
}

//SeasonalDiscount 클래스: Discountable 인터페이스 구현
class SeasonalDiscount4 implements Discountable4 {
	private double discountRate;

	public SeasonalDiscount4(double discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public double getDiscountedPrice(double price) {
		return price*discountRate;
	}


}
//Order 클래스
class Order4 extends SeasonalDiscount4{
	private final int N = 20;
	private Customer4 customer; // 고객명
	private Item4[] items;      // 주문 제품들
	private int[] quantities;  // 주문 제품 수량들
	private String[] orderDates; // 주문일자들 
	private int count = 0;

	public Order4(Customer4 customer) {
		super(0.05);
		this.customer = customer;
		items = new Item4[N];
		quantities = new int[N];
		orderDates = new String[N];
	}

	public void addItem(Item4 item, int quantities, String orderDates) {
		items[count] = item;
		this.quantities[count] = quantities;
		this.orderDates[count] = orderDates;
		count++;
	}

	public double calculateTotal() {
		double total = 0;
		for(int i = 0; i < count; i++) 
			total += items[i].getPrice() * quantities[i];
		return total;
	}

	public void printOrderSummary() {
		System.out.println("고객:"+customer.getName());
		System.out.println("주문요약:");
		double tt = 0;
		for(int i=0; i < count; i++) {
			System.out.println("-"+items[i].getName()+"x"+quantities[i]+"개:단가 W"+items[i].getPrice());
			tt += quantities[i] * items[i].getPrice();
			items[i].setQuantity(quantities[i]);
		}
		System.out.println("할인 미적용 총비용:W"+tt);
	}

	//할인된 내역을 출력하는 메소드

	public void printDiscountDetails() {
		System.out.println("할인 내역:");
		double tt = 0;
		for(int i=0; i < count; i++) {
			System.out.println("-"+items[i].getName()+":원래 가격 W"+items[i].getPrice()+
					", 시즌할인금액 W"+getDiscountedPrice(items[i].getPrice())+
					", 고객할인금액 W"+customer.applyDiscount(items[i].getPrice())+
					",할인 후 가격 W"+(items[i].getPrice()
							-getDiscountedPrice(items[i].getPrice())
							-customer.applyDiscount(items[i].getPrice())
							));
			tt += quantities[i]*(items[i].getPrice()
					-getDiscountedPrice(items[i].getPrice())
					-customer.applyDiscount(items[i].getPrice()));
		}
		System.out.println("할인되어 지불해야 하는 금액= "+tt);
		/*
		 * 정가 - 시즌 할인 적용 - 고객 할인 적용 => 할인된 가격 * 수량 > 총 지불 금액
		 */

	}


}

//Customer 추상 클래스 정의
abstract class Customer4 {
	private String name;
	
	public Customer4(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}


	abstract double applyDiscount(double totalAmount);
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer4 extends Customer4 {
	static final double REGULARDISCOUNT_RATE = 0.03;
	
	public RegularCustomer4(String name) {
		super(name);
	}

	double applyDiscount(double totalAmount) {
		
		return totalAmount*REGULARDISCOUNT_RATE;
	}
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer4 extends Customer4 {
	static final double PREMIUMDISCOUNT_RATE = 0.1;

	public PremiumCustomer4(String name) {
		super(name);
	}
	
	double applyDiscount(double totalAmount) {
		
		return totalAmount*PREMIUMDISCOUNT_RATE;
	}
}
public class 실습8_1동적바인딩_과제 {
	public static void main(String[] args) {
		// Item 타입의 배열 생성
		Item4[] items = new Item4[4];

		// 배열에 전자제품과 의류패션 객체 추가
		items[0] = new Electronics4("노트북", 1500, 100, 23);
		items[1] = new Clothing4("티셔츠", 50, 100, 95);
		items[2] = new Electronics4("휴대폰", 800, 100, 24);
		items[3] = new Clothing4("청바지", 80, 100, 90);

		// 모든 아이템의 이름과 재고량, 가격 출력
		for (Item4 item : items) {
			item.show(); // 동적 바인딩에 의해 각 클래스의 show() 메서드가 호출됨
		}

		// 고객 생성 
		Customer4 regularCustomer = new RegularCustomer4("홍길동");
		Customer4 premiumCustomer = new PremiumCustomer4("강감찬");

		// 주문 생성 및 계산 (RegularCustomer)
		Order4 regularOrder = new Order4(regularCustomer);
		regularOrder.addItem(items[0], 1, "240901");
		regularOrder.addItem(items[1], 2, "240902");

		regularOrder.printOrderSummary();
		regularOrder.printDiscountDetails();

		// 주문 생성 및 계산 (PremiumCustomer)
		Order4 premiumOrder = new Order4(premiumCustomer);
		premiumOrder.addItem(items[1], 1, "240901");
		premiumOrder.addItem(items[3], 2, "240903");
		
		premiumOrder.printOrderSummary();
		premiumOrder.printDiscountDetails();
		
		// 모든 아이템의 이름과 재고량, 가격 출력
		for (Item4 item : items) {
			item.show(); // 동적 바인딩에 의해 각 클래스의 show() 메서드가 호출됨
		}
	}
}