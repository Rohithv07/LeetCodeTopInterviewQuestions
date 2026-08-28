/**
 * @author rohithvazhathody
 * @date 9 Aug 2026
 * Project: CodeforceContestes
 * File: ARibbonForTomorrow.java
 */

package contests.round1116;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class ARibbonForTomorrow {

	private static long MOD = 998244353;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			// 0 white
			// 1 black
			int n = fastReader.nextInt();
			String s = fastReader.next();
			long total = findTotal(s);
			out.println(total);
		}
		out.flush();
		out.close();
	}

	private static long findTotal(String s) {
		// already palindrome -> 1
		if (s.length() == 1) {
			return 1;
		}
		if (isAlreadyPalindrome(s)) {
			return 1;
		}
		return 0;
	}

	private static boolean isAlreadyPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			if (s.charAt(right) != s.charAt(left)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
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
