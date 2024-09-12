package com.ruby.java.ch12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		
		File file = new File("b.txt");
			if(file.exists()) {
			Scanner sc = new Scanner(System.in);
				while(true) {
					System.out.println("이미 존재하는 파일입니다.");
					System.out.println("덮어쓰시겠습니까?[Y/N]");
					String ans = sc.next();
					if (ans.equalsIgnoreCase("Y")) {
						break;
					}
					else if (ans.equalsIgnoreCase("N")) {
						return;
					}
				}
				sc.close();
			}
		
		
		try {FileInputStream fi = new FileInputStream("a.txt");
			FileOutputStream fo = new FileOutputStream("b.txt");
			int c = 0;
			while((c = fi.read()) != -1) { // 글자를 읽었을때 끝이아니면
				fo.write(c); // 그 글자를 저장
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
