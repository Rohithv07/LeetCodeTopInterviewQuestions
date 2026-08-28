/**
 * @author rohithvazhathody
 * @date 26 Jul 2026
 * Project: CodeforceContestes
 * File: BalancedBitstring.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class BalancedBitstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int k = fastReader.nextInt();
			String s = fastReader.next();
			String kString = findKString(s, k);
			out.println(kString);
		}
		out.flush();
		out.close();
	}

	private static String findKString(String s, int k) {
		int n = s.length();
		// pattern array will store the character required at each position modulo k
		// -1 means it's currently flexible (only '?' seen so far)
		int[] pattern = new int[k];
		for (int i = 0; i < k; i++) {
			pattern[i] = -1;
		}

		// Step 1: Enforce s[i] == s[i + k]
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (ch != '?') {
				int val = ch - '0';
				// If a position modulo k already has a conflicting requirement, it's impossible
				if (pattern[i % k] != -1 && pattern[i % k] != val) {
					return "NO";
				}
				pattern[i % k] = val;
			}
		}

		// Step 2: Count how many 0s and 1s are forced in our length-k pattern
		int countZero = 0;
		int countOne = 0;
		for (int i = 0; i < k; i++) {
			if (pattern[i] == 0) {
				countZero++;
			} else if (pattern[i] == 1) {
				countOne++;
			}
		}

		// Step 3: Check if the forced characters exceed our k/2 allowance
		if (countZero > k / 2 || countOne > k / 2) {
			return "NO";
		}

		return "YES";
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
