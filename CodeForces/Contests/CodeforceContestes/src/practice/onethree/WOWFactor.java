/**
 * @author rohithvazhathody
 * @date 19 Apr 2026
 * Project: CodeforceContestes
 * File: WOWFactor.java
 */

package practice.onethree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class WOWFactor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		String s = fastReader.next();
		long totalCount = findTotalCount(s);
		System.out.println(totalCount);
	}

	private static long findTotalCount(String s) {
		String target = "wow";
		long[][] dp = new long[s.length() + 1][target.length() + 1];
		for (int index = 0; index <= s.length(); index++) {
			dp[index][0] = 1;
		}
		for (int index = 0; index <= target.length(); index++) {
			dp[0][index] = 0;
		}
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= target.length(); j++) {
				long total = 0;
				if (target.charAt(j - 1) == 'w') {
					if (i >= 2 && s.charAt(i - 1) == 'v' && s.charAt(i - 2) == 'v') {
						total += dp[i - 1][j - 1];
					}
					total += dp[i - 1][j];
				} else if (target.charAt(j - 1) == 'o') {
					if (s.charAt(i - 1) == 'o') {
						total += dp[i - 1][j - 1];
					}
					total += dp[i - 1][j];
				}
				dp[i][j] = total;
			}
		}
		return dp[s.length()][target.length()];
	}

	private static long count(String s, String target, int i, int j, long[][] dp) {
		// Base cases remain exactly the same
		if (j < 0) {
			return 1;
		}
		if (i < 0) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		long total = 0;

		if (target.charAt(j) == 'w') {
			if (i >= 1 && s.charAt(i) == 'v' && s.charAt(i - 1) == 'v') {
				total += count(s, target, i - 1, j - 1, dp);
			}
			total += count(s, target, i - 1, j, dp);
		} else if (target.charAt(j) == 'o') {
			if (s.charAt(i) == 'o') {
				total += count(s, target, i - 1, j - 1, dp);
			}
			total += count(s, target, i - 1, j, dp);
		}

		return dp[i][j] = total;
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
 * WOW VVOVV
 * 
 * 
 */
