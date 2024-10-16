package chap2_datatype;

import java.util.Scanner;

public class 실습2_5타입변환 {

	public static void main(String[] args) {
		// 정수형에서 실수형으로 변환 (묵시적 형 변환)

	    /*

	    * 정수형 변수를 화면에서 입력받아 double 변수로 변환하여 출력하는 코드를 작성한다.

	    * 출력은 "정수변수값 = **, 실수변수값 = **"

	    */
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		double b;
		b = a;
		System.out.println("정수변수값 = "+a+", 실수변수값 = "+b);


	        // 실수형에서 정수형으로 변환 (명시적 형 변환)

	    /*

	    * 실수형 변수 값을 화면에서 입력받아 정수로 변환하는 코드를 작성한다.

	    * 출력은 "실수변수값 = **, 정수변수값 = **

	    */
		
		Scanner sc1 = new Scanner(System.in);
		double a1 = sc.nextDouble();
		int b1;
		b1 = (int)a1;
		System.out.println("실수변수값 = "+a1+", 정수변수값 = "+b1);

	}

}
