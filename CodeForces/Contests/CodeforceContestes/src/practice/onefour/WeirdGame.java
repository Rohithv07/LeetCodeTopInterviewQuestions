/**
 * @author rohithvazhathody
 * @date 2 May 2026
 * Project: CodeforceContestes
 * File: WeirdGame.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */
public class WeirdGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int n = fastReader.nextInt();
		int m = fastReader.nextInt();
		int[][] grid = new int[n][m];
		int max = (int) (1e5);
		@SuppressWarnings("unchecked")
		List<Integer>[] xcord = new ArrayList[max + 1];
		@SuppressWarnings("unchecked")
		List<Integer>[] ycord = new ArrayList[max + 1];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				grid[row][col] = fastReader.nextInt();
				int color = grid[row][col];
				if (xcord[color] == null) {
					xcord[color] = new ArrayList<>();
					ycord[color] = new ArrayList<>();
				}
				xcord[color].add(row);
				ycord[color].add(col);
			}
		}
		long sum = findSum(grid, xcord, ycord);
		System.out.println(sum);
	}

	private static long findSum(int[][] grid, List<Integer>[] xcord, List<Integer>[] ycord) {
		long total = 0;
		int max = (int) (1e5 + 1);
		for (int index = 1; index < max; index++) {
			if (xcord[index] != null && xcord[index].size() > 1) {
				total += calculateDistance(xcord[index]);
				total += calculateDistance(ycord[index]);
			}
		}
		return total;
	}

	private static long calculateDistance(List<Integer> cord) {
		Collections.sort(cord);
		long total = 0;
		int k = cord.size();
		for (int index = 0; index < k; index++) {
			long val = cord.get(index);
			long elementsLeft = index;
			long elementsRight = k - index - 1;
			long contribution = (val * elementsLeft) - (val * elementsRight);
			total += contribution;
		}
		return total;
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
