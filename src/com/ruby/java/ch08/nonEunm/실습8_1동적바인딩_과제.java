package com.ruby.java.ch08.nonEunm;

//2단계 - 문제 4: 동적바인딩
//Item 추상 클래스
abstract class Item {
	private String name;    // 제품명
	private double price;   // 제품 가격
	private int stockQuantity; // 재고량

	public Item (String name, double price, int stockQuantity) {
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
class Electronics extends Item {
	int madeYear;
	public Electronics(String name, double price, int stockQuantity, int madeYear) {
		super(name, price, stockQuantity);
		this.madeYear = madeYear;
	}
	
	public void show() {
		System.out.println("전자제품:"+getName()+" - W"+getPrice()+"재고량:"+getQuantity()+"제조년도:"+madeYear);
	}

}

//Clothing 클래스: Item 클래스 상속
class Clothing extends Item {
	int size;
	public Clothing(String name, double price, int stockQuantity, int size) {
		super(name, price, stockQuantity);
		this.size = size;
	}
	
	public void show() {
		System.out.println("의류패션:"+getName()+" - W"+getPrice()+"재고량:"+getQuantity()+"치수:"+size);
	}

}
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
		return price*discountRate;
	}


}
//Order 클래스
class Order extends SeasonalDiscount{
	private final int N = 20;
	private Customer customer; // 고객명
	private Item[] items;      // 주문 제품들
	private int[] quantities;  // 주문 제품 수량들
	private String[] orderDates; // 주문일자들 
	private int count = 0;

	public Order(Customer customer) {
		super(0.05);
		this.customer = customer;
		items = new Item[N];
		quantities = new int[N];
		orderDates = new String[N];
	}

	public void addItem(Item item, int quantities, String orderDates) {
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
abstract class Customer {
	private String name;
	
	public Customer(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}


	abstract double applyDiscount(double totalAmount);
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer extends Customer {
	static final double REGULARDISCOUNT_RATE = 0.03;
	
	public RegularCustomer(String name) {
		super(name);
	}

	double applyDiscount(double totalAmount) {
		
		return totalAmount*REGULARDISCOUNT_RATE;
	}
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer extends Customer {
	static final double PREMIUMDISCOUNT_RATE = 0.1;

	public PremiumCustomer(String name) {
		super(name);
	}
	
	double applyDiscount(double totalAmount) {
		
		return totalAmount*PREMIUMDISCOUNT_RATE;
	}
}
public class 실습8_1동적바인딩_과제 {
	public static void main(String[] args) {
		// Item 타입의 배열 생성
		Item[] items = new Item[4];

		// 배열에 전자제품과 의류패션 객체 추가
		items[0] = new Electronics("노트북", 1500, 100, 23);
		items[1] = new Clothing("티셔츠", 50, 100, 95);
		items[2] = new Electronics("휴대폰", 800, 100, 24);
		items[3] = new Clothing("청바지", 80, 100, 90);

		// 모든 아이템의 이름과 재고량, 가격 출력
		for (Item item : items) {
			item.show(); // 동적 바인딩에 의해 각 클래스의 show() 메서드가 호출됨
		}

		// 고객 생성 
		Customer regularCustomer = new RegularCustomer("홍길동");
		Customer premiumCustomer = new PremiumCustomer("강감찬");

		// 주문 생성 및 계산 (RegularCustomer)
		Order regularOrder = new Order(regularCustomer);
		regularOrder.addItem(items[0], 1, "240901");
		regularOrder.addItem(items[1], 2, "240902");

		regularOrder.printOrderSummary();
		regularOrder.printDiscountDetails();

		// 주문 생성 및 계산 (PremiumCustomer)
		Order premiumOrder = new Order(premiumCustomer);
		premiumOrder.addItem(items[1], 1, "240901");
		premiumOrder.addItem(items[3], 2, "240903");
		
		premiumOrder.printOrderSummary();
		premiumOrder.printDiscountDetails();
		
		// 모든 아이템의 이름과 재고량, 가격 출력
		for (Item item : items) {
			item.show(); // 동적 바인딩에 의해 각 클래스의 show() 메서드가 호출됨
		}
	}
}