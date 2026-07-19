/**
 * @author rohithvazhathody
 * @date 7 Jun 2026
 * Project: CodeforceContestes
 * File: PalindromeTweleveAndTwoTerms.java
 */

package contests.round1102;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class PalindromeTweleveAndTwoTerms {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			long n = fastReader.nextLong();
			long[] pair = findBeautifulPair(n);
			if (pair.length == 1) {
				System.out.println(pair[0]);
			} else {
				System.out.println(pair[0] + " " + pair[1]);
			}
		}
	}

	private static long[] findBeautifulPair(long n) {
		if (n == 1) {
			return new long[] { 1, 0 };
		}
		if (n == 10) {
			return new long[] { -1 };
		}
		// a + b = n
		// b = n - a
		// b % 12 = (n - a) % 12
		// 0 = n % 12 - a % 12
		long currentRemainder = n % 12;
		long firstNum = 0;
		// we have 0 to 11
		// 1,2,3,4,5,6,7,8,9
		if (currentRemainder <= 9) {
			firstNum = currentRemainder;
		}
		// for 10, we need to take it as 12 + 10
		else if (currentRemainder == 10) {
			firstNum = 22;
		} else {
			firstNum = 11;
		}

		return new long[] { firstNum, n - firstNum };
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
