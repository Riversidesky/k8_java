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


}

//Electronics 클래스: Item 클래스 상속
class Electronics3 extends Item3 {
	int madeYear;

}

//Clothing 클래스: Item 클래스 상속
class Clothing3 extends Item3 {
	int size;

}


//Order 클래스
class Order3 extends SeasonalDiscount{
	private final int N = 20;
	private Customer3 customer; // 고객명
	private Item3[] items;      // 주문 제품들
	private int[] quantities;  // 주문 제품 수량들
	private String[] orderDates; // 주문일자들 
	private static int count = 0;


	public Order3(Customer3 customer)  {//Order3(Customer3 c, int capacity, double discountRate) 로 수정하여 main()에서 초기 값을 설정
		super(0.05);

	}

	public void addItem(Item3 item, int quantity, String date) {

	}

	public double calculateTotal() {
		double total = 0;

	}

	public void printOrderSummary() {

	}
	// 할인된 내역을 출력하는 메소드
  public void printDiscountDetails() {

  }
}

//Customer 추상 클래스 정의
abstract class Customer3 {
	private String name;

	abstract double applyDiscount(double totalAmount);
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer3 extends Customer3 {
	static final double REGULARDISCOUNT_RATE = 0.03;

}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer3 extends Customer3 {
	static final double PREMIUMDISCOUNT_RATE = 0.1;

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