package Chap5_Recursive;

public class train_5_5_2문자열순열실습 {

    // 주어진 문자 배열의 순열을 생성하는 함수
    public static void permutate(char[] arr, int index) {
        for(int i=index; i<arr.length; i++) {
        	System.out.println(arr[i]);
        }
    }

    // 두 요소를 교환하는 함수
    public static void swap(char[] arr, int i, int j) {
    	char temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }

    public static void main(String[] args) {
        // 문자열을 문자 배열로 변환
        String l = "abcde";
        char[] arr = l.toCharArray();

        // 순열 생성 및 출력
        permutate(arr, 0);
    }
}
