/**
 * @author AJWuu
 */

package strassenAlgorithm;

import java.util.Scanner;

public class StrassenAlgorithm {

	private static int max(int a, int b, int c) {
		if (a > b) {
			if (a > c) {
				return a;
			}
			else {
				return c;
			}
		}
		else {
			if (b > c) {
				return b;
			}
			else {
				return c;
			}
		}
	}

	private static double[][] AdhocMultiply(double[][] x, double[][] y) {
		double[][] z = new double[2][2];
		double p1, p2, p3, p4, p5, p6, p7;
		
		p1=(y[0][1] - y[1][1]) * x[0][0];
        p2=y[1][1] * (x[0][0] + x[0][1]);
        p3=(x[1][0] + x[1][1]) * y[0][0];
        p4=x[1][1] * (y[1][0] - y[0][0]);
        p5=(x[0][0] + x[1][1]) * (y[0][0]+y[1][1]);
        p6=(x[0][1] - x[1][1]) * (y[1][0]+y[1][1]);
        p7=(x[0][0] - x[1][0]) * (y[0][0]+y[0][1]);
        z[0][0] = p5 + p4 - p2 + p6;
        z[0][1] = p1 + p2;
        z[1][0] = p3 + p4;
        z[1][1] = p5 + p1 - p3 - p7;
		
		return z;
	}
	
	private static void DivideMatrix(double[][] A, double[][] a11, double[][] a12, double[][] a21, double[][] a22, int k) {
		for (int i=0; i<k; i++) {
			for (int j=0; j<k; j++) {
				a11[i][j] = A[i][j];
				a12[i][j] = A[i][j+k];
				a21[i][j] = A[i+k][j];
				a22[i][j] = A[i+k][j+k];
			}
		}
	}

	private static double[][] MergeMatrices(double[][] c11, double[][] c12, double[][] c21, double[][] c22, int k) {
		double[][] C = new double[2*k][2*k];
		for (int i=0; i<k; i++) {
			for (int j=0; j<k; j++) {
				C[i][j] = c11[i][j];
				C[i][j+k] = c12[i][j];
				C[i+k][j] = c21[i][j];
				C[i+k][j+k] = c22[i][j];
			}
		}
		return C;
	}

	private static double[][] Subtraction(double[][] M1, double[][] M2, int k) {
		double[][] result = new double[k][k];
		for (int i=0; i<k; i++) {
			for (int j=0; j<k; j++) {
				result[i][j] = M1[i][j] - M2[i][j];
			}
		}
		return result;
	}

	private static double[][] Addition(double[][] M1, double[][] M2, int k) {
		double[][] result = new double[k][k];
		for (int i=0; i<k; i++) {
			for (int j=0; j<k; j++) {
				result[i][j] = M1[i][j] + M2[i][j];
			}
		}
		return result;
	}

	private static double[][] Strassen(double[][] A, double[][] B, int n) {
		int k = n/2;
		double[][] C = new double[k][k];
		if (k == 1) {
			C = AdhocMultiply(A, B);
		}
		else {
			//Create sub-matrices
			double[][] a11 = new double[k][k];
			double[][] a12 = new double[k][k];
			double[][] a21 = new double[k][k];
			double[][] a22 = new double[k][k];
			double[][] b11 = new double[k][k];
			double[][] b12 = new double[k][k];
			double[][] b21 = new double[k][k];
			double[][] b22 = new double[k][k];
			double[][] c11 = new double[k][k];
			double[][] c12 = new double[k][k];
			double[][] c21 = new double[k][k];
			double[][] c22 = new double[k][k];
			double[][] S1, S2, S3, S4, S5, S6, S7, S8, S9, S10;
			double[][] P1, P2, P3, P4, P5, P6, P7;

			//Do the math work of Strassen's Algorithm
			DivideMatrix(A, a11, a12, a21, a22, k);
			DivideMatrix(B, b11, b12, b21, b22, k);

			S1 = Subtraction(b12, b22, k);
			S2 = Addition(a11, a12, k);
			S3 = Addition(a21, a22, k);
			S4 = Subtraction(b21, b11, k);
			S5 = Addition(a11, a22, k);
			S6 = Addition(b11, b22, k);
			S7 = Subtraction(a12, a22, k);
			S8 = Addition(b21, b22, k);
			S9 = Subtraction(a11, a21, k);
			S10 = Addition(b11, b12, k);

			P1 = Strassen(a11, S1, k);
			P2 = Strassen(S2, b22, k);
			P3 = Strassen(S3, b11, k);
			P4 = Strassen(a22, S4, k);
			P5 = Strassen(S5, S6, k);
			P6 = Strassen(S7, S8, k);
			P7 = Strassen(S9, S10, k);

			c11 = Addition(Subtraction(Addition(P5, P4, k), P2, k), P6, k);
			c12 = Addition(P1, P2, k);
			c21 = Addition(P3, P4, k);
			c22 = Subtraction(Subtraction(Addition(P5, P1, k), P3, k), P7, k);

			//Arrange final result
			C = MergeMatrices(c11, c12, c21, c22, k);
		}
		return C;
	}

	public static void main(String[] args) {
		//Get the matrices
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter in order: the ranks of the matrices (3 integers), "
							+ "the elements of MatrixA (row first), "
							+ "the elements of MatrixB (row first): ");

		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int n = max(a, b, c);

		if (n == 1) {
			System.out.println(in.nextDouble() * in.nextDouble());
		}
		else {
			//To use Strassen's Algorithm, we need to make the matrix[2^k][2^k] by padding the operands with 0s
			if (Math.log(n)/Math.log(2)%1 != 0) {
				//n is not a power of 2
				n = (int) Math.pow(2, (n/2+1));
			}

			double[][] MatrixA = new double[n][n];
			for (int i=0; i<a; i++) {
				for (int j=0; j<b; j++) {
					MatrixA[i][j] = in.nextInt();
				}
			}
			double[][] MatrixB = new double[n][n];
			for (int i=0; i<b; i++) {
				for (int j=0; j<c; j++) {
					MatrixB[i][j] = in.nextInt();
				}
			}
			in.close();

			//Calculate and Output
			double[][] output = new double[n][n];
			output = Strassen(MatrixA, MatrixB, n);
			for (int i=0; i<a; i++) {
				for (int j=0; j<c; j++) {
					System.out.print(output[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
