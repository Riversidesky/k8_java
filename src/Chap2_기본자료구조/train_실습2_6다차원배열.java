package Chap2_기본자료구조;

/*
 * 3번째 실습
 * 교재 83 - 배열 처리 + function parameter 전달 숙달 훈련 
 *  함수에서 배열을 리턴할 때 리턴 타입 정의할 수 있어야 한다
 */

import java.util.Arrays;
import java.util.Random;
public class train_실습2_6다차원배열 {
	static Random rand = new Random();

	public static void main(String[] args) {
		int [][]A = new int[2][3];
		int [][]B = new int[3][4];
		int [][]C = new int[2][4];
		inputData(A);
		inputData(B);
		int [][]D = A.clone();//교재83 - 배열 복제
		System.out.println("A[2][3] = ");
		showData("행렬 A", A);
		System.out.println("D[2][3] = ");
		showData("행렬 D", D);
		System.out.println();
		System.out.println("B[3][4] = ");
		showData("행렬 B", B);
		int [][]E = addMatrix(A,D);
		System.out.println("E[2][3] = ");
		showData("행렬 E", E);
		C = multiplyMatrix(A,B); // 그냥 행렬 곱셈은 행과 열을 곱해야하지만
		System.out.println("C[2][4] = ");
		showData("행렬 C", C);

		int [][]F = transposeMatrix(D);
		System.out.println("F[3][2] = ");
		showData("행렬 F", F);
		System.out.println();
		C= multiplyMatrixTransposed(A,F);
		showData("행렬 곱셈 결과-전치행렬 사용", C); //전치행렬을 사용하면 행끼리 곱하면 됨
	}
	static void inputData(int [][]data) {
//		{n, n, n}
//		{n, n, n}
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[0].length; j++) {
				data[i][j] = rand.nextInt(1, 10);
			}
		}
	}
	static void showData(String msg, int[][]items) {
		for(int i=0; i<items.length; i++) {
			System.out.print("[");
			for(int j=0; j<items[0].length; j++) {
				System.out.print(items[i][j]);
				if(j!=items[0].length-1) {
					System.out.print(",");
				}
			}
			System.out.println("]");
		}
	}
	static boolean equals(int[][]a, int[][]b) { //행과 열의 개수가 같은지, 원소가 같은지 체크
		boolean result = false;
		if((a.length == b.length) && a[0].length ==b[0].length) {
			for(int i=0; i<a.length; i++) {
				for(int j=0; j<b[0].length; j++) {
					if(a[i][j] == b[i][j]) {
						result = true;
					}
				}
			}			
		}
		
		return result;
	}
	static int[][] addMatrix(int [][]X, int[][]Y) {
		int Z[][] = new int[X.length][X[0].length];
		for(int i=0; i<X.length; i++) {
			for(int j=0; j<X[0].length; j++) {
				Z[i][j] = X[i][j] + Y[i][j];
			}
		}
		return Z;
	}
	//Z[0][0] = X[0][0]*Y[0][0] + X[0][1]*Y[1][0] + X[0][2]*Y[2][0]
	//Z[0][1] = X[0][0]*Y[0][1] + X[0][1]*Y[1][1] + X[0][2]*Y[2][1]
	//Z[0][2] = X[0][0]*Y[0][2] + X[0][1]*Y[1][2] + X[0][2]*Y[2}[2}
	static int[][] multiplyMatrix(int [][]X, int[][]Y) { //행렬 곱셈
		int Z[][] = new int[X.length][Y[0].length];
		for(int i=0; i<Z.length; i++) {
			for(int j=0; j<Z[0].length; j++) {
				int temp = 0;
				for(int k=0; k<Y.length; k++) {
					temp += X[i][k]*Y[k][j];
				}
				Z[i][j] = temp;
			}
		}
		return Z;
	}
//	7 6 00 = 00 01 10
//	3 7
//	6 7
	static int[][] transposeMatrix(int [][]X) { //전치행렬로 변환
		int Y[][] =  new int[X[0].length][X.length];
		for(int i=0; i<X[0].length; i++) {
			for(int j=0; j<X.length; j++) {
				Y[i][j] = X[j][i];
			}
		}
		
		return Y;
	}
	static int[][] multiplyMatrixTransposed(int [][]X, int[][]Y){ //똑같ㅇ??
		int Z[][] = new int[X.length][Y[0].length];
		for(int i=0; i<Z.length; i++) {
			for(int j=0; j<Z[0].length; j++) {
				int temp = 0;
				for(int k=0; k<Y.length; k++) {
					temp += X[i][k]*Y[k][j];
				}
				Z[i][j] = temp;
			}
		}
		return Z;
	}
}

