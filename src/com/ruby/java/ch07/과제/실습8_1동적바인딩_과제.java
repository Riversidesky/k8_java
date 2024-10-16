package com.ruby.java.ch07.과제;

//2단계 - 문제 4: 동적바인딩
//Item 추상 클래스
abstract class Item {
private String name;    // 제품명
private double price;   // 제품 가격
private int stockQuantity; // 재고량


}

//Electronics 클래스: Item 클래스 상속
class Electronics extends Item {
	int madeYear;

}

//Clothing 클래스: Item 클래스 상속
class Clothing extends Item {
	int size;

}
//Discountable 인터페이스 정의
interface Discountable {
double getDiscountedPrice(double price);
}

//SeasonalDiscount 클래스: Discountable 인터페이스 구현
class SeasonalDiscount implements Discountable {
private double discountRate;


}
//Order 클래스
class Order extends SeasonalDiscount{
	private final int N = 20;
private Customer customer; // 고객명
private Item[] items;      // 주문 제품들
private int[] quantities;  // 주문 제품 수량들
private String[] orderDates; // 주문일자들 
private static int count = 0;

}

//Customer 추상 클래스 정의
abstract class Customer {
private String name;


abstract double applyDiscount(double totalAmount);
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer extends Customer {
	static final double REGULARDISCOUNT_RATE = 0.03;

}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer extends Customer {
static final double PREMIUMDISCOUNT_RATE = 0.1;


}
public class 실습8_1동적바인딩_과제 {
public static void main(String[] args) {
 // Item 타입의 배열 생성
 Item[] items = new Item[4];

 // 배열에 전자제품과 의류패션 객체 추가
 items[0] = new Electronics("노트북", 1500, 24, 23);
 items[1] = new Clothing("티셔츠", 50, 50, 95);
 items[2] = new Electronics("휴대폰", 800, 12, 24);
 items[3] = new Clothing("청바지", 80, 30, 90);

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

 // 주문 생성 및 계산 (PremiumCustomer)
 Order premiumOrder = new Order(premiumCustomer);
 premiumOrder.addItem(items[1], 1, "240901");
 premiumOrder.addItem(items[3], 2, "240903");

 premiumOrder.printOrderSummary();
 // 모든 아이템의 이름과 재고량, 가격 출력
 for (Item item : items) {
     item.show(); // 동적 바인딩에 의해 각 클래스의 show() 메서드가 호출됨
 }
}
}
