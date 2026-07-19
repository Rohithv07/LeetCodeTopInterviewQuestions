/**
 * @author rohithvazhathody
 * @date 4 Jul 2026
 * Project: CodeforceContestes
 * File: AnAlternatingWay.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class AnAlternatingWay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			long[] a = new long[n + 1];
			long[] b = new long[n + 1];
			for (int index = 1; index <= n; index++) {
				a[index] = fastReader.nextLong();
			}
			for (int index = 1; index <= n; index++) {
				b[index] = fastReader.nextLong();
			}
			if (canMakeEqual(a, b)) {
				out.println("YES");
			} else {
				out.println("NO");
			}
		}
		out.flush();
		out.close();
	}

	private static boolean canMakeEqual(long[] a, long[] b) {
		long oddSum = 0;
		long evenSum = 0;
		for (int index = 1; index < a.length; index++) {
			long currentDiff = b[index] - a[index];
			long previousDiff = b[index - 1] - a[index - 1];
			long diff = currentDiff + previousDiff;
			if (index % 2 == 0) {
				evenSum += diff;
				if (evenSum < 0) {
					return false;
				}
			} else {
				oddSum += diff;
				if (oddSum < 0) {
					return false;
				}
			}
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
