package chap5_객체;
class Armor {
	String name; //field 정의
	int height;
	int weight;
	int speed;
	int speedUp(int value) { //메소드
		speed += value;
		return speed;
	}
}
class Person {
    // 필드
	/*
	 * name은 String, age는 int, weight는 float로 필드 선언
	 */
	
	String name;
	int age;
	float weight;

    // 메소드
    void show() {
    	/*
    	 * name=**, age = **, weight = ** 형태로 출력
    	 */
    	System.out.println("name = "+name+", age = "+age+", weight = "+weight);
    }
}
public class 실습5_1클래스객체 {
	    public static void main(String[] args) {
	        // 객체 생성
	    	int a = 10;
	    	int arr[] = new int[5];
	    	Armor mark16 = new Armor();
	    	mark16.speedUp(10); // 메소드 호출
	    	mark16.name = "강감찬";
	    	//mark16.takeOff();
	        Person p = new Person();
	        p.name = "홍길동";
	        p.age = 25;
	        p.weight = 60.56f;

	        // 메소드 호출
	        p.show();
	        
	        /*
	         * [강감찬, 55, 62.34] 객체를 만들어
	         * name=**, age = **, weight = ** 형태로 출력
	         */
	        
	        Person q = new Person();
	        q.name = "강감찬";
	        q.age = 55;
	        q.weight = 62.34f;
	        
	        q.show();
	    }
	}

