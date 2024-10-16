package edu;

import java.util.Scanner;

public class Test19_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // control + 대문자O 하면 자동으로 임포트해줌
		System.out.print("Score:");
		int score = sc.nextInt();
		
		System.out.println(score >= 60 ? "합격" : "불합격"); // 삼항연산자

	}

}
