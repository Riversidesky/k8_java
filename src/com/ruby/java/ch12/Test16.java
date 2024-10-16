package com.ruby.java.ch12;

import java.io.FileInputStream;
import java.io.ObjectInputStream; // 컨트롤 + 쉬프트 + O 필요한 import문 생성or제거

public class Test16 {
	public static void main(String[] args) {
		try(ObjectInputStream in =
				new ObjectInputStream(new FileInputStream("user.txt"))) {
			UserBean user = (UserBean) in.readObject();
			System.out.println(user);
		} catch(Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
