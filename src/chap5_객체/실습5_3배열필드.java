package chap5_객체;
class Person3 {
	// 필드 (private)
	/*
	 * name은 String, age는 int, weight는 float로 필드들을 private 선언
	 * subjects을 교육과목 private 배열
	 * years을 수강 연도 private 배열
	 * count 필드를 사용하여 수강 과목 증가시마다 ++count
	 */

	private String name;
	private int age;
	private float weight;
	private String[] subjects;
	private int[] years;
	private int count;

	// 필드
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}
	public void setYears(int[] years) {
		this.years = years;
	}

	// 메소드
	void show() {
		// 기본 정보 출력::name=**, age=**, weight=**로 출력
		System.out.println("name="+name+", age="+age+", weight="+weight);
		// 교육과목 및 수강 연도 출력
//		for (int i=0; i < subjects.length; i++) {
//			System.out.print("교육과목="+subjects[i]+", 수강연도"+years[i]+"\n");
//		}

		/*
		 * while 문을 사용하여 교육과목과 수강연도를 출력
		 */
		int j = 0;
		while (j < subjects.length) {
			System.out.print("교육과목="+subjects[j]+", 수강연도"+years[j]+"\n");
			j++;
		}
	}

	void addSubjectYear(String subject, int year) {
		String[] s = new String[subjects.length+1];
		for(int i=0; i<subjects.length; i++) {
			s[i] = subjects[i];
		}
		s[subjects.length] = subject;
		
		int[] y = new int[years.length+1];
		for(int i=0; i<years.length; i++) {
			y[i] = years[i];
		}
		y[years.length] = year;
		
		subjects = s;
		years = y;
		
		
	}//과목, 수강연도를 매개변수로 전달받아 배열에 추가
}
public class 실습5_3배열필드 {
	public static void main(String[] args) {
		// 첫 번째 객체 생성 및 초기화
		Person3 p1 = new Person3();
		//다음 코드를 setter, addSubjectYear를 사용하여 수정
		p1.setName("홍길동");
		p1.setAge(25);
		p1.setWeight(60.56f);
		p1.setSubjects(new String[] {"Mathematics", "Science", "History"});
		p1.setYears(new int[] {2020, 2021, 2022});
		p1.addSubjectYear("English", 2023);

		// 메소드 호출
		p1.show();

		// 두 번째 객체 생성 및 초기화
		Person3 p2 = new Person3();
		p2.setName("강감찬");
		p2.setAge(55);
		p2.setWeight(62.34f);
		p2.setSubjects(new String[] {"Literature", "Philosophy", "Physics"});
		p2.setYears(new int[] {2018, 2019, 2020});
		p2.addSubjectYear("English", 2021);

		// 메소드 호출
		p2.show();
	}
}

