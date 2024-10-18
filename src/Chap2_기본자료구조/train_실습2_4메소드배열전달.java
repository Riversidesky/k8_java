package Chap2_기본자료구조;
/*
 * 2장과제1: 메소드 함수에 parameter 전달
 * 메소드에 배열 전달 실습: 교재 59 - 메소드의 매개변수로 배열 사용하기
 * function parameters를 작성할 수 있어야 한다 
 */

import java.util.Random;
public class train_실습2_4메소드배열전달 {
	static int top = 0;
	static final int MAX_LENGTH = 20;
	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		showData("소스데이터",data);
		int max = findMax(data);
		System.out.println("\nmax = " + max);
		boolean existValue = findValue(data, 3);
		System.out.println("찾는 값 = " + 3 + ", 존재여부 = " + existValue);
		reverse(data);// 역순으로 출력 
		showData("역순 데이터", data);
		
	}
	static void showData(String m, int[] d) {
		//top 갯수까지 출력한다 [1,2,3]등으로 출력하도록 작성
		int a = 0;
		System.out.print(m+" : [");
		for (int n : d) {
			System.out.print(n);
			while(a < 9) {
				System.out.print(",");
				break;
			}
			a++;
		}
		System.out.print("]");
		
	}
	static void inputData(int[] arr) {//교재 63 - 난수의 생성
		//top이 배열에 저장된 갯수를 저장
		Random rand = new Random();
		int len = arr.length;
		while(top < len) {
			arr[top] = rand.nextInt(MAX_LENGTH);
			top++;
		}
	}
	static int findMax(int[] arr) {
		int max = arr[0];
		for(int i=0; i<arr.length; i++) {
			if ((i+1) == 10) {
				break;
			}
			if (max < arr[i+1]) {
				max = arr[i+1];
			}
			
		}
		return max;
	}
	static boolean findValue(int[] d, int n) {
		//items[]에 value 값이 있는지를 찾아 존재하면 true, 없으면 false로 리턴
		boolean b = false;
		for(int i=0; i<d.length; i++) {
			if(d[i] == n) {
				b = true;
			}
		}
		
		return b;
	}
	
	static void swap(int[] d, int idx1, int idx2) {
		int t = d[idx1];
		d[idx1] = d[idx2];
		d[idx2] = t;
		
	}

	static void reverse(int[] d) {
		for(int top=0; top<(d.length/2); top++) {
			swap(d, top, (d.length-top-1));
//			0, 9
//			1, 8
//			2, 7
//			3, 6
//			4, 5
		}
	}
}
