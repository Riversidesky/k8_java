package home;

public class ExamA3 {

	public static void main(String[] args) {
		String[] names = {"홍길동", "김유신", "계백", "강감찬", "을지문덕"};
		String[] subjs = {"수학", "국어", "영어", "과학", "역사"};
		int[] criteria = 	{50,60,70,80,80};
		int[][] scores = {  {85,90,78,88,92},
							{75,80,85,90,95},
							{65,70,75,80,85},
							{95,92,88,84,91},
							{88,76,85,79,90} };

		//		반복문/삼항연산자를 이용하여 학생별, 과목별 점수, 통과여부 출력
		//		5개 과목의 총점 및 평균 점수를 테이블로 출력
		//		과목별 최대, 최소 점수를 구하고, 해당 점수의 학생 이름을 테이블로 출력
		
		for (int i=0; i < names.length; i++) {
			System.out.println("["+names[i]+"]");
			for (int j=0; j < names.length; j++) {
				String ox = criteria[j] < scores [i][j] ? "통과" : "과락";
				System.out.println("\t"+subjs[j]+" : "+scores[i][j]+" => "+ox);

			}
		}
		System.out.println("=============================================");
		System.out.println("이름"+"\t"+"수학"+"\t"+"국어"+"\t"+"영어"+"\t"+"과학"+"\t"+"역사");
		System.out.println("---------------------------------------------");
		
//		이름0 점수00 점수01 점수02 점수03 점수04 점수 05
//		이름1 점수10 점수11 점수12
		
		for(int k=0; k <names.length; k++) {
			System.out.print(names[k]);
			for(int l=0; l <names.length; l++) {
				System.out.print("\t"+scores[k][l]);
			}
			System.out.println();
		}
		
		System.out.println("=============================================");
		System.out.println("과목"+"\t"+"점수"+"\t"+"이름");
		System.out.println("---------------------------------------------");
		
		int max = scores[0][0];
		int min = scores[0][0];
		
//	최대 최솟값 구하기
//		scores00 01 02 03 04 비교
//		      10 11 12 13 14
		
		미해결
		
		for(int m=0; m<subjs.length; m++) {
			for(int n=0; n<subjs.length; n++) {
				if (max < scores[m][n]) {
					max = scores[m][n];
				}
				if (scores[m][n] <= max) {
					min = scores[m][n];
				
			}
				
			System.out.println(subjs[m]+"\t"+max+"\t"+names[m]);
		}
		
	}
		System.out.println(max);
		System.out.println(min);

}}
