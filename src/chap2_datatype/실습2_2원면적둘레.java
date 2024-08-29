package chap2_datatype;

public class 실습2_2원면적둘레 {
	public static void main(String[] args) {
	    // 실수형 변수 선언 및 초기화

	    /*

	    * 원의 반지름 7.5를 변수 radius로 선언한다

	    */

		double radius = 7.5;

	        // 원의 면적과 둘레 계산

	    /*

	    * 원의 면적은 area, 둘레는 circumference 변수에 저장한다. 

	    * 원 면적은 pi * r * r

	    * 원 둘레는 2 * pi * r

	    * pi 값은 3.14159로 사용하거나 Math.PI를 사용한다

	    */

		
		double pi = 3.14159;
		double area = Math.PI * radius * radius;
		double circumference = 2 * Math.PI * radius;

	        // 결과 출력

	    /*

	    * 출력 형태는 다음과 같이 1줄에 출력한다.

	    * "원의 면적 = **, 원의 둘레 = **"

	    */
		System.out.println("원의 면적 = "+area+", 원의 둘레 = "+circumference);
	}
}
