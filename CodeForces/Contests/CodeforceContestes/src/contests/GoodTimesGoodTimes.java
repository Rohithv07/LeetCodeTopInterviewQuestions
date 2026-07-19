/**
 * @author rohithvazhathody
 * @date 4 Jul 2026
 * Project: CodeforceContestes
 * File: GoodTimesGoodTimes.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class GoodTimesGoodTimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			long x = fastReader.nextLong();
			long y = findY(x);
			out.println(y);
		}
		out.flush();
		out.close();
	}

	private static long findY(long x) {
		long y = 1;
		while (x > 0) {
			y *= 10;
			x /= 10;
		}
		return y + 1;
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
