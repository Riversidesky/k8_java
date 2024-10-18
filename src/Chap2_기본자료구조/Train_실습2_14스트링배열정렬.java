package Chap2_기본자료구조;

import java.util.Arrays;

/*
 * 2장 실습과제4 - 스트링 배열 정렬
 * 정렬된 배열에 insert하면 중간에 끼워 넣으면 큰 값들은 이동해야 하고 크기를 1 증가 처리가 필요 
 */
public class Train_실습2_14스트링배열정렬 {
	public static void main(String[] args) {
		String []data = {"apple","grape","persimmon", "pear","blueberry", "strawberry", "melon", "oriental melon"};
		System.out.println(data.length);
		System.out.println(data[0].compareTo(data[4]));
		showData("정렬전", data);
		sortData(data);
		//comparable interface와 comparator interface를 구분 - 3장
//		Arrays.sort(data);
		showData("정렬후", data);
		String[] newData = insertString(data, "banana");
		showData("삽입후 크기가 증가된 정렬 배열", newData);
		
	}
	static void showData(String m, String[] d) {//확장된 for 문으로 출력 
		System.out.println(m);
		for (String a : d) {
			System.out.println(a);
		}
	}

	static void swap(String[] d, int i, int j) {//스트링의 맞교환 함수로 sortData()에서 호출됨
		String t = d[i];
		d[i] = d[j];
		d[j] = t;
		
	}
	static void sortData(String[] d) {//올림차순으로 정렬 - for 문을 사용하여 직접 구현한다 버블정렬 205p!!!
		for(int i=0; i<d.length-1; i++) {
			for(int j=0; j<d.length-1-i; j++) {
				if(d[j].compareTo(d[j+1]) > 0) {
					swap(d, j, j+1);
				}				
			}
		}
	}
	static String[] insertString(String[] d, String s){//배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
		String []nd = new String[d.length+1];
		for(int i=0; i<d.length; i++) {
			nd[i] = d[i];
		}
		nd[nd.length-1] = s;
		
		sortData(nd);
		return nd;
	}
}
