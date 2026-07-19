/**
 * @author rohithvazhathody
 * @date 18 Jul 2026
 * Project: CodeforceContestes
 * File: IskanderAndDrawings.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class IskanderAndDrawings {

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
			int maxTime = findMaxTime(s);
			out.println(maxTime);
		}
		out.flush();
		out.close();
	}

	private static int findMaxTime(String s) {
		int length = s.length();
		int countLine = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '#') {
				countLine++;
			}
		}
		if (countLine == 0) {
			return 0;
		}
		if (countLine == length) {
			return (length + 1) / 2;
		}
		int runningCount = 0;
		int maxCount = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '#') {
				runningCount++;
			} else {
				runningCount = 0;
			}
			maxCount = Math.max(maxCount, runningCount);

		}
		return (maxCount + 1) / 2;
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
