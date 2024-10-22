package Chap4_스택과큐;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * 실습 4_2번
 * 교재에 있는 소스코드
 * 입력하여 실행 실습
 * 정수형 스택 리스트
 * 객체스택과 큐에 대한 구현도 정수 스택의 예외처리 방식을 반복 적용함 
 */

import java.util.Scanner;

//int형 고정 길이 스택

class IntStack4 {
	private List<Integer> stk; // 스택용 리스트
	private int capacity; // 스택의 크기
	private int ptr; // 스택 포인터

//--- 실행시 예외: 스택이 비어있음 ---//
	public class EmptyIntStackException extends RuntimeException {

		public EmptyIntStackException(String string) {
			// TODO Auto-generated constructor stub
		}
//추가
	}

//--- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowIntStackException extends RuntimeException {

		public OverflowIntStackException(String string) {
			// TODO Auto-generated constructor stub
		}
//추가
	}

//--- 생성자(constructor) ---//
	public IntStack4(int maxlen) {
		ptr = 0;
		capacity = maxlen;
//추가
		try {
			stk = new ArrayList<>(maxlen);
		//추가
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

//--- 스택에 x를 푸시 ---//
	public void push(int x) throws OverflowIntStackException {
		if (isFull()) // 스택이 가득 참
			throw new OverflowIntStackException("push: stack overflow");
		stk.add(x);
		ptr++;
//추가
	}

//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public int pop() throws EmptyIntStackException {
		if (isEmpty()) // 스택이 빔
			throw new EmptyIntStackException("pop: stack empty");
		return stk.get(--ptr);
//추가
	}

//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public int peek() throws EmptyIntStackException {
		if (isEmpty()) // 스택이 빔
			throw new EmptyIntStackException("peek: stack empty");
		return stk.get(ptr-1);
//추가
	}

//--- 스택을 비움 ---//
	public void clear() throws EmptyIntStackException {
		/*
		 * stack을 empty로 만들어야 한다.
		 * stack이 empty일 때 clear()가 호출된 예외 발생해야 한다 
		 * pop()으로 구현하지 않고 대신에 while 문으로 remove()를 반복 실행한다
		 */
		if (isEmpty()) // 스택이 빔
			throw new EmptyIntStackException("peek: stack empty");
		
		int i = ptr;
		while(i <= 0) {
			stk.remove(i);
			i--;
		}
		ptr = 0;
//추가
	}

//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(int x) {
		for(int i=0; i<ptr; i++) {
			if(stk.get(i) == x) return i;
		} return -1;
//추가
	}

//--- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
		//추가
	}

//--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return ptr;
	//추가
	}

//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return ptr <= 0;
		//추가
	}

//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return ptr >= capacity;
		//추가
	}
	
//--- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
	public void dump() throws EmptyIntStackException{
		if (isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			throw new EmptyIntStackException("peek: stack empty");
		}
		else {
			for(int i=0; i<ptr; i++) {
				System.out.println(stk.get(i));
			}
		}
	}
}
public class train_실습4_2_1정수스택리스트 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack4 s = new IntStack4(4); // 최대 64 개를 푸시할 수 있는 스택
		Random rnd = new Random();
		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(5)clear  (0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {

			case 1: // 푸시
				System.out.print("데이터: ");
				x = rnd.nextInt(10);
				try {
					s.push(x);
				} catch (IntStack4.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 2: // 팝
				try {
					x = s.pop();
					System.out.println("팝한 데이터는 " + x + "입니다.");
				} catch (IntStack4.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 3: // 피크
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntStack4.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 4: // 덤프
				try {
					s.dump();
				} catch (IntStack4.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;
			case 5: //clear
				try {
					s.clear();
				} catch (IntStack4.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;
				
			}
		}
	}
}