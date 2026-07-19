/**
 * @author rohithvazhathody
 * @date 18 Jul 2026
 * Project: CodeforceContestes
 * File: PathsOnAGrid.java
 */

package contests.round1111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class PathsOnAGrid {

	private static final long MOD = 998244353;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int row = fastReader.nextInt();
			int col = fastReader.nextInt();
			int[][] grid = new int[row][col];
			for (int index = 0; index < row; index++) {
				String currentRow = fastReader.next();
				for (int currentCol = 0; currentCol < col; currentCol++) {
					grid[index][currentCol] = currentRow.charAt(currentCol) - '0';
				}
			}
			long totalCount = findTotalCount(grid);
			out.println(totalCount);
		}
		out.flush();
		out.close();
	}

	private static long findTotalCount(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		return totalCount(grid, 0, 0, row, col);
	}

	private static long totalCount(int[][] grid, int currentRow, int currentCol, int row, int col) {
		if (!isSafe(grid, currentRow, currentCol, row, col)) {
			return 0;
		}
		if (currentRow == row - 1 && currentCol == col - 1) {
			return 1;
		}
		long count = 0;
		count = (count + totalCount(grid, currentRow + 1, currentCol, row, col)) % MOD;
		count = (count + totalCount(grid, currentRow, currentCol + 1, row, col)) % MOD;
		return count % MOD;
	}

	private static boolean isSafe(int[][] grid, int currentRow, int currentCol, int row, int col) {
		return currentRow >= 0 && currentCol >= 0 && currentRow < row && currentCol < col
				&& grid[currentRow][currentCol] == 1;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

}
