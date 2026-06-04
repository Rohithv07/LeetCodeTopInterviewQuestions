/**
 * @author rohithvazhathody
 * @date 27 May 2026
 * Project: CodeforceContestes
 * File: BasketBallExercise.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class BasketBallExercise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int n = fastReader.nextInt();
		long [] row1 = new long [n];
		long [] row2 = new long [n];
		for (int index = 0; index < n; index++) {
			row1[index] = fastReader.nextLong();
		}
		for (int index = 0; index < n; index++) {
			row2[index] = fastReader.nextLong();
		}
		long maxHeight = findMaxHeight(row1, row2);
		System.out.println(maxHeight);
	}
	
	private static long findMaxHeight(long[] row1, long[] row2) {
		int length = row1.length;
		long [] dp1 = new long [length];
		long [] dp2 = new long [length];
		dp1[0] = row1[0];
		dp2[0] = row2[0];
		for (int index = 1; index < length; index++) {
			dp1[index] = Math.max(dp1[index - 1], dp2[index - 1] + row1[index]);
			dp2[index] = Math.max(dp2[index - 1], dp1[index - 1] + row2[index]);
		}
		return Math.max(dp1[length - 1], dp2[length - 1]);
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



/*
 * 
 * 
 * 
 * 5
	9 3 5 7 3
	5 8 1 4 5
 * 
 * 3 3 5
 * 1 4 5
 * 
 * 9 8 7 5
 * 
 */
