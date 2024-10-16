package chap1_기본알고리즘;

import java.util.Arrays;

public class 실습1_4_문자데이터변환_과제 {
/*
 * valueOf(boolVal)
 * Arrays.sort(array)
 */
    // 값을 문자열로 변환하여 배열에 저장하는 함수
	private static String[] convertValuesToString(boolean b, char c, double d, int i, float f) {
		String[] array = new String[5];
		array[0] = String.valueOf(b);
		array[1] = String.valueOf(c);
		array[2] = String.valueOf(d);
		array[3] = String.valueOf(i);
		array[4] = String.valueOf(f);
		return array;
	}


	// 배열을 정렬하는 함수
    
	private static void sortStringArray(String[] stringArray) {
		Arrays.sort(stringArray);
		
	}

    // 배열을 출력하는 함수
	
	private static void showAllString(String[] stringArray) {
		for (String s : stringArray) {
			System.out.print(s+" ");
		}
		
	}
    
    public static void main(String[] args) {
        // 정수, float, double, boolean 값을 문자열로 변환하여 배열에 저장
        String[] stringArray = convertValuesToString(true, 'A', 3.14, 123, 45.67f);
        
        // 정렬 전 배열 출력
        System.out.println("정렬전:");
        showAllString(stringArray);
        
        // 배열 정렬
        sortStringArray(stringArray);
        
        // 정렬 후 배열 출력
        System.out.println("\n정렬후:");
        showAllString(stringArray);
    }

}

