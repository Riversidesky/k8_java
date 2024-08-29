package edu;

public class Test30_1 {

	public static void main(String[] args) {
		int j = 0;
		for (int i = 1; i <= 100; i++) {
			if ((i % 2) == 0) {
				System.out.println(i + "은 2의 배수 입니다.");
				if ((i % 3) == 0) {
					System.out.println(i + "은 3의 배수 입니다.");
					j++; //공배수만 출력하려면 for(int i = 1 ; i <=100 ; i++) { if(i%2==0 && i%3==0)
				}
			}
		}
		System.out.println("2와 3의 공배수의 개수는" + j + "개 입니다."); // ctrl + shift + F 들여쓰기
	}
}
