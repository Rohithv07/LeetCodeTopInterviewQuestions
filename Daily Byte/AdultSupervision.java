/*
You are given a MxN matrix and a value k. Every value in the matrix is a one which represents an adult and a zero which represents a child. For every row in the matrix, adults appear before children. A row that has more adults than another row is more strongly supervised. Return the k rows of matrix that have the least amount of supervision in ascending order.
Note: It is guaranteed no ties will occur for the number of adults in a row.

Ex: Given the following matrix and k...

matrix = [
  [1, 1, 0],
  [1, 0, 0],
  [0, 0, 0]
], k = 3, return [2, 1, 0] (row 2 has least adults followed by row 1 and row 0).
Ex: Given the following matrix and k...

matrix = [
  [1, 1, 1],
  [1, 1, 0],
  [1, 0, 0]
], k = 2, return [2, 1].
*/

import java.util.*;

public class AdultSupervision {

	public static int [] decreasedRow(int [][] mat, int row, int col, int k) {
		PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
		for (int i=0; i<row; i++) {
			int countAdult = 0;
			for (int j=0; j<col; j++) {
				if (mat[i][j] == 1)
					countAdult += 1;
			}
			pq.add(new int []{i, countAdult});
			if (pq.size() > k) {
				pq.remove();
			}
		}
		int [] result = new int [k];
		int index = k - 1;
		while (!pq.isEmpty()) {
			int []rowIndexCombined = pq.poll();
			result[index--] = rowIndexCombined[0];
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int mat [][] = new int [row][col];
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		int k = sc.nextInt();
		int [] result = decreasedRow(mat, row, col, k);
		for (int number : result) {
			System.out.print(number + " ");
		}
	}
}