/**
 * @author rohithvazhathody
 * @date 24 Nov 2026
 * Project: CodeforceContestes
 * File: NestedSegments.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class NestedSegments {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = 1;
		while (test-- > 0) {
			int n = fastReader.nextInt();
			long[][] range = new long[n][3];
			for (int index = 0; index < n; index++) {
				range[index][0] = fastReader.nextLong();
				range[index][1] = fastReader.nextLong();
				range[index][2] = index + 1;
			}
			int[] result = findSegments(range);
			out.println(result[0] + " " + result[1]);
		}
		out.flush();
		out.close();
	}

	private static int[] findSegments(long[][] range) {
		Arrays.sort(range, (r1, r2) -> {
			if (r1[0] == r2[0]) {
				return Long.compare(r2[1], r1[1]);
			}
			return Long.compare(r1[0], r2[0]);
		});
		long max = range[0][1];
		long resultIndex = range[0][2];
		for (int index = 1; index < range.length; index++) {
			if (max >= range[index][1]) {
				return new int[] { (int)range[index][2], (int)resultIndex };
			}
			if (range[index][1] > max) {
				max = range[index][1];
				resultIndex = range[index][2];
			}
		}
		return new int[] { -1, -1 };
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			try {
				while (st == null || !st.hasMoreTokens()) {
					st = new StringTokenizer(br.readLine());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

}
