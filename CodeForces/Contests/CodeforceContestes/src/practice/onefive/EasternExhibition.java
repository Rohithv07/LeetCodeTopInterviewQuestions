/**
 * @author rohithvazhathody
 * @date 15 Jul 2026
 * Project: CodeforceContestes
 * File: EasternExhibition.java
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
public class EasternExhibition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			long[]x = new long[n];
			long [] y = new long [n];
			for (int index = 0; index < n; index++) {
				x[index] = fastReader.nextLong();
				y[index] = fastReader.nextLong();
			}
			long positions = findDifferentPosition(x, y);
			out.println(positions);
		}
		out.flush();
		out.close();
	}

	private static long findDifferentPosition(long[] x, long[] y) {
		Arrays.sort(x);
		Arrays.sort(y);
		int length = x.length;
		long medianX = x[length / 2] - x[(length - 1) / 2] + 1;
		long medianY = y[length / 2] - y[(length - 1) / 2] + 1;
		return medianX * medianY;
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
