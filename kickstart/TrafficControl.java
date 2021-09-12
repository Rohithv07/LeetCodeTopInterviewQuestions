package HackerCupFirstRound;

import java.util.Arrays;
import java.util.Scanner;

public class TrafficControl {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t=1; t<=test; t++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			int topLeftToBottomRight = sc.nextInt();
			int topRightToBottomLeft = sc.nextInt();
			if (row + col - 1 > topLeftToBottomRight || row + col - 1 > topRightToBottomLeft) {
				System.out.println("Case #" + t + ": Impossible");
			}
			else {
				System.out.println("Case #" + t + ": Possible");
				int [][] result = fillTheMatrix(row, col, topLeftToBottomRight, topRightToBottomLeft);
				//System.out.println();
				for (int i=0; i<result.length; i++) {
					for (int j=0; j<result[0].length; j++) {
						System.out.print(result[i][j] + " ");
					}
					System.out.println();
				}
			}
		}
	}

	private static int[][] fillTheMatrix(int row, int col, int topLeftToBottomRight, int topRightToBottomLeft) {
		int [][] result = new int [row][col];
		for (int [] resultRow: result) {
			Arrays.fill(resultRow, -1);
		}
		for (int i=0; i<col; i++) {
			result[0][i] = 1;
		}
		for (int i=1; i<row; i++) {
			result[i][col-1] = 1;
		}
		for (int i=1; i<row; i++) {
			result[i][0] = 1;
		}
		int totalSumAlongBoundary = row + col - 2;
		int remainingToFillLeftToBottomRight = topLeftToBottomRight - totalSumAlongBoundary;
		int remainingToFillRightToBottomLeft = topRightToBottomLeft - totalSumAlongBoundary;
		result[row - 1][col - 1] = remainingToFillLeftToBottomRight;
		result[row - 1][0] = remainingToFillRightToBottomLeft;
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (result[i][j] == -1) {
					result[i][j] = 2;
				}
			}
		}
		return result;
	}
}
