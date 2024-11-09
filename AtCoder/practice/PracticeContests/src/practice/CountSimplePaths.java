/**
 * 
 */
package practice;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 */
public class CountSimplePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		char [][] mat = new char[row][col];
		boolean [][] visited;
		int [] count = new int [1];
		int k = sc.nextInt();
		for (int i = 0; i < row; i++) {
			String s = sc.next();
			for (int j = 0; j < col; j++) {
				mat[i][j] = s.charAt(j);
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (mat[i][j] == '.') {
					visited = new boolean [row][col];
					dfs(i, j, mat, visited, count, k);
				}
			}
		}
		System.out.println(count[0]);
		
	}

	private static void dfs(int i, int j, char[][] mat, boolean[][] visited, int[] count, int k) {
		if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || visited[i][j] || mat[i][j] == '#') {
			return;
		}
		if (k == 0) {
			count[0]++;
			return;
		}
		visited[i][j] = true;
		dfs(i + 1, j, mat, visited, count, k - 1);
		dfs(i - 1, j, mat, visited, count, k - 1);
		dfs(i, j + 1, mat, visited, count, k - 1);
		dfs(i, j - 1, mat, visited, count, k - 1);
		visited[i][j] = false;
		
	}

}
