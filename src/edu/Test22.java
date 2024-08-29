package edu;

public class Test22 {

	public static void main(String[] args) {
		int a = 12;
		int b = 2;
		char op = '+';
		
		switch(op) {
		case '+': // switch 문은 ;가 아니라 :
			System.out.println(a + b); break;
		case '-':
			System.out.println(a - b); break;
		case '*':
			System.out.println(a * b); break;
		case '/':
			System.out.println(a / b); break;
		}

	}

}
