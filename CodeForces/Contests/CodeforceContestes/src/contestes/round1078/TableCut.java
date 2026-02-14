/**
 * @author rohithvazhathody
 * @date 8 Feb 2026
 * Project: CodeforceContestes
 * File: TableCut.java
 */

package contestes.round1078;

import java.util.Scanner;

/**
 * 
 */
public class TableCut {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			int[][] mat = new int[row][col];
			int totalOne = 0;
			for (int currentRow = 0; currentRow < row; currentRow++) {
				for (int currentCol = 0; currentCol < col; currentCol++) {
					mat[currentRow][currentCol] = sc.nextInt();
					if (mat[currentRow][currentCol] == 1) {
						totalOne++;
					}
				}
			}
			long max = (totalOne / 2) * ((totalOne + 1)/ 2);
			System.out.println(max);
			String path = findMaxPath(mat, totalOne);
			System.out.println(path);
		}
		sc.close();
	}

	private static String findMaxPath(int[][] mat, int totalOne) {
		
		return null;
	}

}
