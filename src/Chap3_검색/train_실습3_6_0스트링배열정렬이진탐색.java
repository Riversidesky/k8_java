package Chap3_검색;

import java.util.Arrays;

public class train_실습3_6_0스트링배열정렬이진탐색 {

	public static void main(String[] args) {
		String []data = {"사과","포도","복숭아", "감", "산딸기", "블루베리", "대추", "수박", "참외"};
		showData("정렬전", data);
		sortData(data);//올림차순으로 정렬 교재211-212 단순 선택 정렬 알고리즘으로 구현
		System.out.println();
		showData("정렬후", data);

		String key = "포도";
		int resultIndex = linearSearch(data, key);//교재 100 페이지 seqSearch() 함수로 구현
		System.out.println("\nlinearSearch(포도): key = " + key + ", result 색인 = " + resultIndex);

		key = "배";
		resultIndex = binarySearch(data, key);//교재 109 페이지 binSearch() 함수로 구현
		System.out.println("\nbinarySearch(배):key = " + key + ",  result = " + resultIndex);
		key = "산딸기";
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(산딸기): key = " + key + ", result = " + resultIndex);
	}


	private static void showData(String string, String[] data) {
		for(String d : data) {
			System.out.print(d);
		}
	}
	
	private static void sortData(String[] data) {
		for(int i=0; i < data.length-1; i++) {
			int min = i;
			for(int j=i+1; j<data.length; j++) {
				if(data[min].compareTo(data[j]) > 0) {
					min = j;
				}
			}
			swap(data, i, min);
		}
	}
	
	private static void swap(String[] a, int i, int j) {
		String t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static int linearSearch(String[] data, String key) {
		int index = -1;
		for(int i=0; i<data.length; i++) {
			if (data[i] == key) {
				index = i;
			}
		}
		return index;
	}
	
	private static int binarySearch(String[] data, String key) {
		int start = 0;
		int end = data.length-1;
		int mid = (start+end) / 2;
		while (start <= end) {
			if (data[mid] == key) {
				return mid;
			} else if (data[mid].compareTo(key) > 0) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		};
		return -1;
	}
}
