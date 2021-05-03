/*
Given a two-dimensional integer array, accounts, each row in the matrix represents the total wealth of the ith customer. The total wealth of a customer is given by the sum of their j account in the ith row. Return the wealth of the richest customer.

Ex: Given the following accounts…

accounts = [
  [1, 2, 3],
  [4, 5, 6]
], return 15 (4 + 5 + 6 = 15).
Ex: Given the following accounts…

accounts = [
  [1, 2],
  [2, 1]
], return 3.

*/


import java.util.*;

public class MostWealth {

	public static int findTheRich(int [][] matrix, int row, int col) {
		int whichRow = 0;
		int indexOfRow = 0;
		int sum = 0;
		for (int [] r : matrix) {
			int currentRowSum = 0;
			for (int i=0; i<col; i++) {
				currentRowSum += r[i];
			}
			if (currentRowSum > sum) {
				whichRow = indexOfRow++;
				sum = currentRowSum;
			}
			else {
				indexOfRow += 1;
			}
		}
		System.out.println("The richest row is " + whichRow);
		return sum;
			
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
		System.out.println(findTheRich(matrix, row, col));
	}
}
