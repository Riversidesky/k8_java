package chap4_array;

public class 실습_4_3_2차원행렬더하기 {
	public static void main(String[] args) {
        // 두 개의 2차원 배열 생성 및 초기화
		/*
		 * 행렬 [3][4] A, B를 정수로 선언하고 12개의 값을 초기화
		 */
		int A[][] = {{1,2,3,4},
					{5,6,7,8},
					{9,10,11,12}};
		int B[][] = {{1,2,3,4},
					{5,6,7,8},
					{9,10,11,12}};
        // 결과를 저장할 2차원 배열
		/*
		 * C = A + B => 행렬 A와 B를 더하여 C에 넣기 위한 정수 배열 C를 선언
		 */
		
		int C[][] = new int[3][4];
		

        // 행렬 더하기
		/*
		 * A, B를 더한 결과를 저장하는 C를 구하는 for 문 구현
		 */
		
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[i].length; j++) {
				C[i][j] = A[i][j]+B[i][j];
			}
		}

        // 결과 출력
		/*
		 * 행렬 A, B, C를 출력하는 코드 작성
		 * 출력 형태는 
		 * "A = 
		 *      1,2,3,4,5,6,7
		 *      8,9, ...
		 *  B = 
		 *  
		 *  C = 
		 */
		
		System.out.println("A = "+"\t");
		for(int k=0; k<A.length; k++) {
			for(int l=0; l<A[k].length; l++) {
				System.out.print(A[k][l]+",");
			}
		}
		System.out.print("\b"+"\n");
		
		System.out.println("B = "+"\t");
		for(int k=0; k<A.length; k++) {
			for(int l=0; l<A[k].length; l++) {
				System.out.print(B[k][l]+",");
			}
		}
		System.out.print("\b"+"\n");
		
		System.out.println("C = "+"\t");
		for(int k=0; k<A.length; k++) {
			for(int l=0; l<A[k].length; l++) {
				System.out.print(C[k][l]+",");
			}
		}
		System.out.print("\b"+"\n");
    }
}
