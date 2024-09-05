package com.ruby.java.ch08.nonEunm;

enum Status1 {
	READY, SEND, COMPLETE, CLOSE
}

public class EnumTest01 {
	public static void main(String[] args) {
		Status1 work = null;
		
		int n = 2;
		
		switch (n) {
		case 1:
			work = Status1.READY;
			break;
	
		case 2:
			work = Status1.SEND;
			break;
		
		case 3:
			work = Status1.COMPLETE;
			break;
	
		case 4:
			work = Status1.CLOSE;
			break;
	}
	
	System.out.println("현재 작업 상태 : "+work);
	}
}
