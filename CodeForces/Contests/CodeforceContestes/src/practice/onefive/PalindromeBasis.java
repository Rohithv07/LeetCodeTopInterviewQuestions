/**
 * @author rohithvazhathody
 * @date 14 Jun 2026
 * Project: CodeforceContestes
 * File: PalindromeBasis.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class PalindromeBasis {

	private static final long MOD = (long) (1e9 + 7);
	private static final int SIZE = (int) (4e4);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		boolean[] palindromeList = new boolean[SIZE + 1];
		fillPalindromeList(palindromeList, SIZE);
		long[] dp = new long[SIZE + 1];
		dp[0] = 1;
		for (int currentValue = 1; currentValue <= SIZE; currentValue++) {
			if (!palindromeList[currentValue]) {
				continue;
			}
			for (int sum = currentValue; sum <= SIZE; sum++) {
				dp[sum] = (dp[sum] + dp[sum - currentValue]) % MOD;
			}
		}
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			long totalCount = dp[n];
			out.println(totalCount);
		}
		out.flush();
		out.close();
	}

	private static void fillPalindromeList(boolean[] palindromeList, int n) {
		for (int index = 1; index <= n; index++) {
			if (index <= 9) {
				palindromeList[index] = true;
			} else {
				palindromeList[index] = checkForPalindrome(index);
			}
		}
	}

	private static boolean checkForPalindrome(int num) {
		int temp = num;
		int val = 0;
		while (num > 0) {
			int mod = num % 10;
			val = val * 10 + mod;
			num /= 10;
		}
		return temp == val;
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
