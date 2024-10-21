package Chap3_검색;
/*
* 3장 1번 실습과제: 03-3 정수배열이진검색
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
* 3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
*/
import java.util.Arrays;
import java.util.Random;
//class A implements Comparable<A> { //comparable interface와 comparator interface를 구분 - 3장//comparator과 구분
//	int num;
//	@Override 
//	public int compareTo(A c) {
//		return num - c.num; 
//	}
//
//	@Override
//	public boolean equals(Object c) {//Object 클래스 오버라이딩 구현
//		if(num == ((A)c).num)
//			return true;
//		return false;
//	}
//}
public class train_실습3_4정수배열이진탐색 {

	static Random rand = new Random();
	public static void main(String[] args) {
//		String st = "hello";
//		System.out.println(st.compareTo(st)); //string 비교
//		A ax = new A();
//		A bx = new A();
//		if(ax.equals(bx)) {
//			System.out.println("같다");
//		}
		
		int []data = new int[30];
		inputData(data);// 구현 반복 숙달 훈련 - 100 이하 난수를 생성

		showList("정렬 전 배열[]:: ", data);
		Arrays.sort(data);
		System.out.println();
		showList("정렬 후 배열[]:: ", data);// 구현 반복 숙달 훈련
		System.out.println();

		int key = 13;
		boolean resultIndex = linearSearch(data, key);//교재 99-100:실습 3-1 참조, 교재 102: 실습 3-2
		//Arrays 클래스에 linear search는 없기 때문에 구현해야 한다 
		System.out.println("\nlinearSearch(13): key = " + key + ", result = " + resultIndex);

		key = 19;
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);//함수 구현이 필요
		System.out.println("\nbinarySearch(19): key = " + key + ", result = " + resultIndex);
		
		key = 10;
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		
		int resultIndex2 = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(1	0): result = " + resultIndex2);

	}
	
	private static boolean binarySearch(int[] data, int key) {
		int pl = 0;
		int pr = data.length-1;
		
		int pc = (pl+pr)/2;
		
		do {
			if(data[pc] == key) {
				return true;
			} else if(data[pc] > key) {
				pr = pc-1;
			} else {
				pr = pc+1;
			}
			
		} while (pl <= pr);
		
//		 while (pl <= pr) {
//		        if (data[pc] == key) {
//		            return true; // 키를 찾았을 때
//		        } else if (data[pc] > key) {
//		            pr = pc - 1; // 왼쪽 서브 배열로 이동
//		        } else {
//		            pl = pc + 1; // 오른쪽 서브 배열로 이동
//		        }
//		    }

		return false;
		
	}

	private static boolean linearSearch(int[] data, int key) {
		boolean result = false;
		int index = -1;
		for(int i=0; i<data.length; i++) {
			if(data[i] == key) {
				result = true;
				index = i;
				break;
			}
		}
		if(index == -1) {
			System.out.println("찾는 값이 없다.");
		} else {
			System.out.println("찾는 인덱스 "+index);
		}
		
		return result;
	}

	static void inputData(int data[]) {
		for(int i=0; i<data.length; i++) {
			data[i] = rand.nextInt(100);
		}
	}
	
	static void showList(String m, int data[]) {
		int a = 0;
		System.out.print("[");
		for(int d : data) {
			System.out.print(d);
			while(a<data.length-1) {
				System.out.print(",");
				break;
			}
			a++;
		}
		System.out.print("]");
	}
}
