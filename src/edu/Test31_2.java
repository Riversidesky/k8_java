package edu;

import java.util.Scanner;

public class Test31_2 { // for문 3개

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int col = sc.nextInt();
		
			for(int i = 1; i < 10; i++) {
				for(int j = 2; j <10; j++) {
					System.out.print(j + "*" + i + "=" + (i * j) + " ");
				}
				System.out.println("\n");
		}
			// 4 입력받으면 1단 2단 3단 4단
				//       5단 6단 7단 8단
			 //          9단 출력
	}

}