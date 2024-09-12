package com.ruby.java.ch12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

public class Test01_01 {
	public static void main(String[] args) {
		//arg 배열 만들고 출력
		//run as - run configurations - arguments
		if (args.length != 2) {
			System.out.println("");
			return;
		}
		
		System.out.println(args[0]);
		System.out.println(args[1]);
		
		long start = System.currentTimeMillis();
		copyFile(args[0], args[1]);
		System.out.println("copyFile : " + (System.currentTimeMillis()-start));
		start = System.currentTimeMillis();
		copyFile1(args[0], args[1]);
		System.out.println("copyFile1 : " + (System.currentTimeMillis()-start));
	}

	private static void copyFile1(String string, String string2) {
		try {FileInputStream fi = new FileInputStream(string);
		FileOutputStream fo = new FileOutputStream(string2);
		int c = 0;
		while((c = fi.read()) != -1) { // 글자를 읽었을때 끝이아니면
			fo.write(c); // 그 글자를 저장
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void copyFile(String string, String string2) {
		try {BufferedInputStream fi = new BufferedInputStream(new FileInputStream(string));
		BufferedOutputStream fo = new BufferedOutputStream(new FileOutputStream(string2));
		int c = 0;
		while((c = fi.read()) != -1) { // 글자를 읽었을때 끝이아니면
			fo.write(c); // 그 글자를 저장
		}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
