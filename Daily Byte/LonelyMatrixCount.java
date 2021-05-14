/*
Given a binary matrix, return the number of lonely indices.
Note: An index (i, j) is lonely if matrix[i][j] is equal to one and all other elements in the ith row and jth column are zeroes.

Ex: Given the following matrix…

matrix = [
  [1, 0],
  [0, 1]
], return 2.
Ex: Given the following matrix…

matrix = [
  [1, 0, 1],
  [0, 1, 0],
  [0, 0, 1]
], return 1.
*/

import java.util.*;

public class LonelyMatrixCount {

	public static int getLazyCount(int [][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int [] rowSum = new int [row];
		int [] colSum = new int [col];
		int result = 0;
		for (int i=0; i<row; i++) {
			int sum = 0;
			for (int j=0; j<col; j++) {
				sum += matrix[i][j];
			}
			rowSum[i] = sum;
		}
		for (int j=0; j<col; j++) {
			int sum = 0;
			for (int i=0; i<row; i++) {
				sum += matrix[i][j];
			}
			colSum[j] = sum;
		}
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (matrix[i][j] == 1 && rowSum[i] == 1 && colSum[i] == 1)
					result += 1;
			}
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int [][] matrix = new int [row][col];
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		System.out.println(getLazyCount(matrix));
	}
}
