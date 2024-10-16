package chap2_datatype;

public class 실습2_3문자열출력 {

	public static void main(String[] args) {
        // 문자열 변수 선언 및 초기화

    /*

    * 이름, 나이, 도시를 String, int, String으로 선언한다.

    * 3개 변수에 값으로 "홍길동", 25, "부산"으로 초기화한다

    */
		
		String 이름 = "홍길동";
		int 나이 = 25;
		String 도시 = "부산";

        // 사용자 정보 출력

    /*

    * 출력 형태는 다음과 같이 1줄에 출력한다.

    * "이름 = **, 나이 = **, 도시 = **"

    */
		System.out.println("이름 = "+이름+", 나이 = "+나이+", 도시 = "+도시);



	}

}
