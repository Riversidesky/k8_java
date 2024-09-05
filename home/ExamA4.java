package home;

class Student {
	private String name;
	private int[] criteria;
	private int[] scores;
	
	
	
	public Student(String name, int[] criteria, int[] scores) {
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
	
	public int[] getCriteria() {
		return criteria;
	}
	
	public void setCriteria(int[] criterria) {
		this.criteria = criterria;
	}
	
	public int[] getScores() {
		return scores;
	}
	
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
	public double average() {
        return sumScore() / (double) scores.length;
    }
	
	 public int sumScore() {
	        int sum = 0;
	        for (int score : scores) {
	            sum += score;
	        }
	        return sum;
	    }
	
	 public boolean[] isPassed() {
	        boolean[] passed = new boolean[criteria.length];
	        for (int i = 0; i < criteria.length; i++) {
	            passed[i] = scores[i] >= criteria[i];
	        }
	        return passed;
	    }

	public void printStudentInfo() {
		 System.out.println("이름: " + name);
	        for (int i = 0; i < scores.length; i++) {
	            System.out.printf("%s: %d (기준: %d) => %s\n", 
	                              "과목" + (i + 1), 
	                              scores[i], 
	                              criteria[i], 
	                              scores[i] >= criteria[i] ? "통과" : "과락");
	        }
	        System.out.println("총점: " + sumScore());
	        System.out.println("평균: " + average());
	    }
		
	}




public class ExamA4 {

	public static void main(String[] args) {
		String[] subjects = {"수학","국어","영어","과학","역사"};
		int[] criteria = {50,60,70,80,90};
		Student[] students = { 
	            new Student("홍길동", criteria, new int[]{85, 90, 78, 88, 92}),
	            new Student("김유신", criteria, new int[]{75, 80, 85, 90, 95}),
	            new Student("계백", criteria, new int[]{65, 70, 75, 80, 85}),
	            new Student("강감찬", criteria, new int[]{95, 92, 88, 84, 91}),
	            new Student("을지문덕", criteria, new int[]{88, 76, 85, 79, 90})
	        };

		
		for (Student student : students) {
            student.printStudentInfo();
            System.out.println();
        }
	}

}

