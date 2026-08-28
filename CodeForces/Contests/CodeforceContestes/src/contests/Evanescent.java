/**
 * @author rohithvazhathody
 * @date 4 Aug 2026
 * Project: CodeforceContestes
 * File: Evanescent.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class Evanescent {

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
			int minLength = findMinLength(s);
			out.println(minLength);
		}
		out.close();
	}

	private static int findMinLength(String s) {
		int length = s.length();
		int initialBlock = 1;
		for (int index = 0; index + 1 < length; index++) {
			if (s.charAt(index) != s.charAt(index + 1)) {
				initialBlock++;
			}
		}
		int minVal = Integer.MAX_VALUE;
		for (int index = 1; index <= length - 2; index++) {
			int normalCost = (s.charAt(index) != s.charAt(index + 1) ? 1 : 0)
					+ (s.charAt(index - 1) != s.charAt(index) ? 1 : 0);
			int probableDelete = (s.charAt(index - 1) != s.charAt(index + 1) ? 1 : 0);
			int delta = probableDelete - normalCost;
			minVal = Math.min(delta, minVal);
		}
		return minVal + initialBlock;
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
