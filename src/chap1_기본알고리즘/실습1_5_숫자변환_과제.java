package chap1_기본알고리즘;

import java.util.Arrays;

public class 실습1_5_숫자변환_과제 {
/*
 * split(" ")
 * parseInt(stringArray[i])
 */
    // 문자열을 공백으로 분리하여 배열에 저장하고 정렬하는 함수
	private static String[] splitSortString(String input) {
		String[] list = input.split(" ");
		Arrays.sort(list);
		return list;
	}

    // 문자열 배열을 정수 배열로 변환한 후 정렬하는 함수
	private static int[] convertSortToIntArray(String[] sortedStringArray) {
		int[] list = new int[8];
		for(int i=0; i<list.length; i++) {
			list[i] = Integer.parseInt(sortedStringArray[i]);
		}
		Arrays.sort(list);
		return list;
	}

    // 문자열 배열 출력 함수
	private static void printStringArray(String[] sortedStringArray) {
		for(String s : sortedStringArray) {
			System.out.print(s+" ");
		}
	}

    // 정수 배열 출력 함수
    private static void printIntArray(int[] sortedIntArray) {
    	for(int i : sortedIntArray) {
    		System.out.print(i+" ");
    	}
    }

    public static void main(String[] args) {
        String input = "12 111 911 921 94 23 214 222";
        
        // 문자열 배열 정렬 및 출력
        String[] sortedStringArray = splitSortString(input);
        System.out.println("Sorted String Array:");
        printStringArray(sortedStringArray);
        
        System.out.println();
        // 문자열 배열을 정수 배열로 변환 및 정렬 후 출력
        int[] sortedIntArray = convertSortToIntArray(sortedStringArray);
        System.out.println("Sorted Integer Array:");
        printIntArray(sortedIntArray);
    }
}
