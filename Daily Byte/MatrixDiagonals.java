/*
Given a two-dimensional NxN integer array, matrix, return the sum of all values along its two diagonals.
Note: If a value appears in both diagonals it should only be added to your sum once.

Ex: Given the following matrix…

matrix = [
  [1, 2],
  [2, 1]
], return 6 (1 + 1 + 2 + 2).
Ex: Given the following matrix…

matrix = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
], return 25 (5 is only added to the sum once).
*/

import java.util.*;

public class MatrixDiagonals {

	public static int diagonalSum(int [][] mat, int n) {
		int sum = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (i == j)
					sum += mat[i][j];
				else if (i + j == n - 1)
					sum += mat[i][j];
			}
		}
		return sum;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] mat = new int [n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		System.out.println(diagonalSum(mat, n));
	}
}



// code from leetcode

class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += mat[i][i] + mat[i][n - i - 1];
        }
        if (n % 2 != 0)
            sum -= mat[n / 2][n /2];
        return sum;
    }
}
