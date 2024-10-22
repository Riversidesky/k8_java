package chap5_객체;

class Student {
	private String name;
	private int[] criteria;
	private int[] scores;
	
	public Student(String name, String[] subjects, int[] criteria, int[] scores) {
		this.name = name;
		this.criteria = criteria;
		this.scores = scores;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getScores() {
		return scores;
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}

	int average() {
		return sumScore()/scores.length;
	}
	
	int sumScore() {
		int sum = 0;
		for(int i=0; i<scores.length; i++) {
			sum+=scores[i];
		}
		return sum;
	}

	String isPassed(int i) {
		if(criteria[i] > scores[i]) return "(과락)";
		else return "";
	}
	
	@Override
	public String toString() {
		return name+"\t "+sumScore()+"\t "+average()+"\t "+scores[0]+isPassed(0)
		+"\t "+scores[1]+isPassed(1)+"\t "+scores[2]+isPassed(2)+"\t "+scores[3]+isPassed(3)
		+"\t "+scores[4]+isPassed(4);
	}
}

public class ExamA4 {
	public static void main(String[] args) {
		// 과목 배열 정의
		String[] subjects = {"수학","국어","영어","과학","역사"};
		// 과목별 통과 기준 배열 정의
		int[] criteria = { 50, 60, 70, 80, 90 };
		// 학생 배열 생성
		Student[] students = { 
				new Student("홍길동", subjects, criteria,
						new int[]{85, 90, 78, 88, 92}), 
				new Student("김유신", subjects, criteria,
						new int[]{75, 80, 85, 90, 95}), 
				new Student("계백", subjects, criteria,
						new int[]{65, 70, 75, 80, 85}), 
				new Student("강감찬", subjects, criteria,
						new int[]{95, 92, 88, 84, 91}), 
				new Student("을지문덕", subjects, criteria,
						new int[]{88, 76, 85, 79, 90})
		};
		
		System.out.println(">>>각 학생의 성적 테이블 출력");
    	System.out.println("==============================================");
    	System.out.println("이름\t 총점\t 평균\t 수학\t 국어\t 영어\t 과학\t 역사\t");
    	for(Student s : students) {
    		System.out.println(s);
    	}
    	System.out.println(">>>과목별 최대/최소 점수 및 해당 학생 이름 출력");
    	System.out.println("==============================================");
    	System.out.println("과목\t 최고점\t 최저점\t 최고점학생 최저점학생");
    	 for (int j = 0; j < subjects.length; j++) {
    		 int maxScore = students[0].getScores()[j];
    		 int minScore = students[0].getScores()[j];
    		 String maxStudent = students[0].getName();
    		 String minStudent = students[0].getName();
    		 
             for (Student s : students) {
                 int score = s.getScores()[j];
                 
                 if (score > maxScore) {
                     maxScore = score;
                     maxStudent = s.getName();
                 }
                 
                 if (score < minScore) {
                     minScore = score;
                     minStudent = s.getName();
                 }
             }

             System.out.println(subjects[j]+"\t "+maxScore+"\t "+minScore+"\t "+maxStudent+"\t "+minStudent);
         }
	}
}
