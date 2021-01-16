/*
Given an image represented as a 2D array of pixels, return the image rotation ninety degrees.

Ex: Given the following image…

image = [
    [10, 11, 12],
    [13, 14, 15],
    [16, 17, 18]
], return the image such that it's been modified as follows...
[
    [16,13,10],
    [17,14,11],
    [18,15,12]
]
*/

import java.util.*;

public class ImageFlip {

	public static int [][] flip(int [][] matrix) {
		int n = matrix.length;
		transpose(matrix);
		// now reverse the row
		for (int i=0; i<n; i++) {
			int left = 0;
			int right = n - 1;
			while (left < right) {
				int temp = matrix[i][left];
				matrix[i][left] = matrix[i][right];
				matrix[i][right] = temp;
				left += 1;
				right -= 1;
			}
		}
		return matrix;
	}

	public static void transpose(int [][] matrix) {
		for (int i=0; i<matrix.length; i++) {
			for (int j=i+1; j<matrix[0].length; j++) {
				int temp = matrix[i][j];
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
		int [][] flipped = flip(matrix);
		for (int i=0; i<n; i++) {
			System.out.println();
			for (int j=0; j<n; j++) {
				System.out.print(flipped[i][j] + " ");
			}
		}
	}
}