/*

Given a 2D matrix, return a list containing all of its element in spiral order.

Ex: Given the following matrix...

matrix = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
], return [1, 2, 3, 6, 9, 8, 7, 4, 5].

*/


import java.util.*;

public class DownwardSpiral {

	public static List<Integer> makeSpiral(int [][] matrix) {
		List<Integer> result = new ArrayList<>();
		int row = matrix.length;
		int col = matrix[0].length;
		int lowRow = 0;
		int highRow = row - 1;
		int lowCol = 0;
		int highCol = col - 1;
		while (lowRow <= highRow && lowCol <= highCol) {
			for (int i=lowRow; i<=highCol; i++)
				result.add(matrix[lowRow][i]);
			lowRow += 1;
			for (int i=lowRow; i<=highRow; i++)
				result.add(matrix[i][highCol]);
			highCol -= 1;
			if (lowRow <= highRow) {
				for (int i=highCol; i>=lowCol; i--)
					result.add(matrix[highRow][i]);
				highRow -= 1;
			}
			if (lowCol <= highCol) {
				for (int i=highRow; i>=lowRow; i--)
					result.add(matrix[i][lowCol]);
				lowCol += 1;
			}
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] matrix = new int [n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		System.out.println(makeSpiral(matrix));
	}
}