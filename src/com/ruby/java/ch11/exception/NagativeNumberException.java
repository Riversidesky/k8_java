package com.ruby.java.ch11.exception;

public class NagativeNumberException extends Exception {
		public NagativeNumberException() {
			super("음수는 허용하지 않습니다.");
		}
}
