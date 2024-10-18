package Chap2_기본자료구조;
/*
 * 2장 과제2 - 정수 배열 정렬
 * 배열의 크기는 20개, top 변수가 현재 배열에 저장된 갯수를 저장 
 */
import java.util.Arrays;
//교재 67 - 실습 2-5
//2번 실습
import java.util.Random;
public class train_실습2_5정수배열정렬 {
	static int top = 0;
	static final int MAX_LENGTH = 20;
	static Random rand = new Random();
	public static void main(String[] args) {
		
		float []data = new float[MAX_LENGTH];// 0.0 ~ 1.0 사이의 실수를 저장
		inputData(data, 10);//10개의 난수를 입력
		showData("실수 난수 입력", data);//top 개수 만큼 출력
		System.out.println();
		reverse(data);//역순으로 재배치 - 교재 67페이지 참조
		showData("역순 재배치", data);
		System.out.println();
		System.out.println((Arrays.toString(data)));// 교재 84페이지 코드 참조
		showData("실수 스트링의 정렬", data);
		sortData(data);//교재 205 bubbleSort() 함수 코드를 사용 - 올림차순으로 정렬
		System.out.println();
		showData("버블정렬", data);
		float realData = rand.nextFloat(); // 실수 난수 생성
		System.out.println();
		insertData(data, realData);//입력 실수보다 큰 숫자를 우측으로 이동
		showData("실수 삽입후", data);
	}
	
	
	static void inputData(float[] f, int n) {
		//난수 실수를 입력
//		for(int i=0; i<f.length; i++) {
//			f[i] = rand.nextFloat();
//		}
		int count = 1;
		while (top < n) {
			f[top] = rand.nextFloat();
			top += count;
		}
		
	}
	static void showData(String m, float[] f) {//실수 배열을 top 갯수만 출력
//		int a = 0;
//		System.out.print(m+" : [");
//		for (float n : f) {
//			System.out.print(n);
//			while(a < 9) {
//				System.out.print(",");
//				break;
//			}
//			a++;
//		}
//		System.out.print("]");
		System.out.print(m+" ");
		for (int i=0; i<top; i++) {
			System.out.print(f[i]);
			if(i<(top-1)) System.out.print(", ");
		}
		
	}
	static void reverse(float[] f) {//역순으로 재배치 - top 갯수만 역순 재배치
		for(int i=0; i<(f.length/4); i++) {
			swap(f, i, ((f.length/2)-i-1));			
		}
	}
	
	static void swap(float[] f, int i, int j) {//교재 67페이지 - 맞교환
		float t = f[i];
		f[i] = f[j];
		f[j] = t;
	}
	
	static void sortData(float[] f) {//올림차순으로 정렬 - top 갯수를 사용
		for(int i=0; i<(f.length/2)-1; i++) { //루프 한번 돌고나면 f[9]에서부터 하는건 똑같지만 두번째배열까지
			for(int j=(f.length/2)-1; j>i; j--) { //f[9]에서부터
				if(f[j-1] > f[j]) { //왼쪽값이 더크면
					swap(f, j-1, j); //f[j-1]값과 f[j]값을 바꾼다
				}
			}
		}
	}
	static void insertData(float[] f, float f2) {//insert되는 실수 값이 insert될 위치를 찾아 보다 큰 값은 우측으로 이동
		System.out.println("실수 값 "+ f2);
		int ins = 0;
		for(int i=0; i<(f.length/2); i++) {
			if(f[i] <= f2) {
				ins = (i+1);
			}
		}
		System.out.println("insert될 위치 "+ins);
		for(int j=((f.length/2)+1); j>ins; j--) {
			swap(f, j, j-1);
		}
		f[ins] = f2;
		top++;
	}


}
