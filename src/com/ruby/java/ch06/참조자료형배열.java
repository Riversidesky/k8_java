package com.ruby.java.ch06;

class YMD {
	int year;
	int month;
	int day;
	
}

public class 참조자료형배열 {
	public static void main(String[] args) {
		YMD dates[] = new YMD[2];
		
		dates[0] = new YMD();
		dates[0].year = 2020;
		dates[0].month = 1;
		dates[0].day = 12;
		
		dates[1] = new YMD();
		dates[1].year = 2021;
		dates[1].month = 2;
		dates[1].day = 21;
		
		for(int i=0; i < dates.length; i++) {
		System.out.println(dates[i].year+"."+dates[i].month+"."+dates[i].day);
		}
	}	
		
}
