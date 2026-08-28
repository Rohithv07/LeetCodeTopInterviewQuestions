/**
 * @author rohithvazhathody
 * @date 26 Jul 2026
 * Project: CodeforceContestes
 * File: Prepalindrome.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class Prepalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		String s = fastReader.next();
		long total = findTotalSubstring(s);
		out.println(total);
		out.flush();
		out.close();
	}

	private static long findTotalSubstring(String s) {
		int length = s.length();
		long total = 0;
		for (int index = 0; index < length; index++) {
			total += expand(s, index, index);
			total += expand(s, index, index + 1);
		}
		return total;
	}

	private static long expand(String s, int start, int end) {
		int mismatch = 0;
		int count = 0;
		while (start >= 0 && end < s.length()) {
			if (s.charAt(start) != s.charAt(end)) {
				mismatch++;
			}
			if (mismatch == 2) {
				break;
			}
			count++;
			start--;
			end++;
		}
		return count;
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
