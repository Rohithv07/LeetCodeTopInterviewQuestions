/**
 * @author rohithvazhathody
 * @date 3 Jun 2026
 * Project: CodeforceContestes
 * File: MashmokhAndACM.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class MashmokhAndACM {

	private static final long MOD = (long) (1e9 + 7);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int n = fastReader.nextInt();
		int k = fastReader.nextInt();
		long totalSequence = findTotalSequence(n, k);
		System.out.println(totalSequence);
	}

	private static long findTotalSequence(int n, int k) {
		if (k == 1) {
			return n;
		}
		long totalSequence = 0;
		long [][] dp = new long [n + 1][k + 1];
		for (long [] d : dp) {
			Arrays.fill(d, -1L);
		}
		for (int num = 1; num <= n ; num++) {
			totalSequence = (totalSequence + countSequence(n, k, 1, num, dp)) % MOD;
		}
		return totalSequence;
	}

	private static long countSequence(int n, int k, int currentLength, int currentVal, long [][] dp) {
		if (currentLength == k) {
			return 1;
		}
		if (currentVal > n) {
			return 0;
		}
		if (dp[currentVal][currentLength] != -1) {
			return dp[currentVal][currentLength];
		}
		long count = 0;
		// check multiples
		for (int next = currentVal; next <= n; next += currentVal) {
			count = (count + countSequence(n, k, currentLength + 1, next, dp)) % MOD;
		}
		return dp[currentVal][currentLength] = count % MOD;
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
