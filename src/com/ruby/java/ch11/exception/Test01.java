package com.ruby.java.ch11.exception;


public class Test01 {
	public static void main(String[] args) {
			try {
				test01();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				//e.printStackTrace();
			}
			System.out.println("OK");
			
	}
	public static void test01() throws Exception {
//		try {
//			int arr[] = new int [3];
//			arr[3] = 30;
//		} catch(Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		} finally {
//			System.out.println("final");
//		}
		int arr[] = new int [3];
		arr[3] = 30;
	} // 익셉션 << 에러가 발생한 위치
}	  // 익셉션 << 에러발생한걸 처음 호출한 위치
