package Chap2_기본자료구조;
/*
 * 2장 제출 과제 
 * Comparable 인터페이스의 구현 
 * 5번 실습 - 2장 실습 2-10를 수정하여 객체 배열의 정렬 구현
 */
import java.util.Arrays;

class PhyscData implements Comparable<PhyscData>{
	String name;
	int height;
	double vision;
	
	PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	public PhyscData(String name) {
		this.name = name;
	}

	@Override
	public String toString() {//Object 클래스 상속
		return name+"[키:"+height+", 시력:"+vision+"]";
	}
	@Override
	public int compareTo(PhyscData p) {
		if (this.name.compareTo(p.name) > 0) return 1;
		else if (this.name.compareTo(p.name) < 0) return -1;
		else { // 같으면
			if (this.height>p.height) return 1;
			else if (this.height<p.height) return -1;
			else {
				if(this.vision>p.vision) return 1;
				else return -1;
			}
		}
	}
	public boolean equals(Object ob) {//Object 클래스 상속
		 PhyscData p = (PhyscData) ob;
		 if (this.name.equals(p.name)) return true;
			else return false;
	}
}
public class train_실습2_14_1객체배열정렬 {
	private static void swap(PhyscData[] d, int n, int m) {
		PhyscData t = d[n];
		d[n] = d[m];
		d[m] = t;
	}
	private static void sortData(PhyscData[] d) {//객체 배열을 이름 순서로 정렬, 이름이 같으면 키 값을 정렬, 키 값이 같으면 시력으로 
		//compareTo()를 사용하여 구현
		for(int i=0; i<d.length-1; i++) {
			for(int j=d.length-1; j>i; j--) {
				if(d[j-1].compareTo(d[j])>0) swap(d, j-1,j);
			}
		}
	}
	private static int binarySearch(PhyscData[] d, String s) {
		//if (data[i].equals(key)) ***으로 구현
		PhyscData dt = new PhyscData(s);
		int pl = 0;
		int pr = d.length-1;
		do {
			int mid = (pl+pr) / 2;
			if(d[mid].equals(dt))	
				return mid;
			else if(d[mid].compareTo(dt) < 0)	
				pl = mid+1;
			else 
				pr = mid-1;
		} while(pl<=pr);
		return -1;
	} //equals()를 사용하여 구현
	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("이기자", 164, 1.3),
				new PhyscData("나가자", 162, 0.7),
				new PhyscData("사이다", 172, 0.3),
				new PhyscData("신정신", 182, 0.6),
				new PhyscData("원더풀", 167, 0.2),
				new PhyscData("다정해", 169, 0.5),
		};
		showData("정렬전",data);
		sortData(data);
		showData("정렬후", data);
		int resultIndex = binarySearch(data, "사이다");
		System.out.println("인덱스값 : "+resultIndex);
		PhyscData[] newData= insertObject(data, new PhyscData("소주다", 179, 1.5));//배열의 사이즈를 1개 증가시킨후 insert되는 객체 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 객체 배열을 리턴
		showData("삽입후", newData);
		
	}
	private static void showData(String s, PhyscData[] d) {
		System.out.println(s);
		for(PhyscData dt : d) {
			System.out.println(dt);
		}
	}
	private static PhyscData[] insertObject(PhyscData[] d, PhyscData nd){//배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
		PhyscData[] newArr = new PhyscData[d.length+1];
		for(int i=0; i<d.length; i++) {
			newArr[i] = d[i];
		}
		newArr[newArr.length-1] = nd;
		sortData(newArr);
		return newArr;
	}

}
