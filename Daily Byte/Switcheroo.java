Given a 2D matrix nums, return the matrix transposed.
Note: The transpose of a matrix is an operation that flips each value in the matrix across its main diagonal.

Ex: Given the following matrix nums…

nums = [
  [1, 2],
  [3, 4]
]
return a matrix that looks as follows...
[
  [1,3],
  [2,4]
]


import java.util.*;

public class Switcheroo {

	public static void transpose(int [][] matrix) {
		int temp;
		for (int i=0; i<matrix.length; i++) {
			for (int j=i+1; j<matrix.length; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
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
		transpose(matrix);
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}