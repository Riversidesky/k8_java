package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Test10 {
	public static void main(String[] args) {
		lotto_generator(5);
	}

	private static void lotto_generator(int n) {
		Random number = new Random(100); // 시드값 지정
		HashSet<Integer> lotto = null;
		for(int i = 0; i < n; i++) {
			
			lotto = new HashSet<Integer>();
			
			while(lotto.size() < 7) { 
				lotto.add(number.nextInt(45)+1);
			}
			
			List<Integer> L = new ArrayList<Integer>(lotto);
			Collections.sort(L);
			System.out.println(L);
		}
		
	}
}
