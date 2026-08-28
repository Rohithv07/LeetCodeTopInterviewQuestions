/**
 * @author rohithvazhathody
 * @date 9 Aug 2026
 * Project: CodeforceContestes
 * File: DominoTiles.java
 */

package contests.round1116;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class DominoTiles {

	private static final long MOD = 998244353;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			String s = fastReader.next();
			long totalWays = findTotalWays(s);
			out.println(totalWays);
		}
		out.flush();
		out.close();
	}

	private static long findTotalWays(String s) {
		long[][][] dp = new long[s.length()][4][4];
		for (long[][] d : dp) {
			for (long[] dd : d) {
				Arrays.fill(dd, -1);
			}
		}
		return findTotal(s, 0, 3, 3, dp);
	}

	private static long findTotal(String s, int index, int previousSum1, int previousSum2, long[][][] dp) {
		if (index == s.length()) {
			return 1;
		}
		if (dp[index][previousSum1][previousSum2] != -1) {
			return dp[index][previousSum1][previousSum2];
		}
		long total = 0;
		for (int current = 0; current <= 1; current++) {
			char ch = (current == 0) ? '0' : '1';
			char currentMarkedChar = s.charAt(index);
			if (currentMarkedChar != '?' && currentMarkedChar != ch) {
				continue;
			}
			if (previousSum2 != 3) {
				if (previousSum2 == current) {
					continue;
				}
			}
			total = (total + findTotal(s, index + 1, current, previousSum1, dp)) % MOD;
		}
		return dp[index][previousSum1][previousSum2] = total;
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
 * 0 1 0 1 1
 * 
 * 
 */
