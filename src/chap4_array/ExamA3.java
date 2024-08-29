package chap4_array;

public class ExamA3 {
	public static void main(String[] args) {
		String[] names = {"홍길동", "김유신", "계백", "강감찬", "을지문덕"};
		
		String[] subjs = {"수학", "국어", "영어", "과학", "역사"};
		
		int[] criteria = {50, 60, 70, 80, 80};
		
		int[][] scores = {{85, 90, 78, 88, 92},
				{75, 80, 85, 90, 95},
				{65, 70, 75, 80, 85},
				{95, 92, 88, 84, 91},
				{88, 76, 85, 79, 90}};
		
		
		
			for (int i=0; i < scores.length; i++) {
				System.out.println("["+names[i]+"]");
				for(int j=0; j < scores[i].length; j++) {
				String value = scores[i][j]>=criteria[j] ? "통과" : "과락";
				System.out.println("\t"+subjs[j]+" : "+scores[i][j]+" => "+value);
				}
			}
			
			System.out.println(">>>>과목 총점 및 평균 점수를 테이블로 출력");
			System.out.println("=======================================");
			System.out.println("이름"+"\t"+"수학"+"\t"+"국어"+"\t"+"영어"+"\t"+"과학"+"\t"+"역사");
			for (int k=0; k < scores.length; k++) {
				System.out.print(names[k]+"\t");
				System.out.println(scores[k][0]);
			}
			미완성
		}
	}

