/**
 * @author rohithvazhathody
 * @date 18 Jul 2026
 * Project: CodeforceContestes
 * File: YetAnotherConstructive.java
 */

package contests.round1111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */
public class YetAnotherConstructive {

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
			long m = fastReader.nextLong();
			List<Long> result = findNiceArray(n, k, m);
			if (result.isEmpty()) {
				out.println("NO");
			} else {
				out.println("YES");
				for (long val : result) {
					out.print(val + " ");
				}
				out.println();
			}
		}
		out.flush();
		out.close();
	}

	private static List<Long> findNiceArray(int n, int k, long m) {
		List<Long> result = new ArrayList<>();
		if (k > m) {
			return result;
		}
		long large = m - k + 1;
		for (int index = 0; index < k - 1; index++) {
			result.add(1l);
		}
		if (n >= k) {
			result.add(large);
		}
		for (int index = k; index < n; index++) {
			if ((index + 1) % k == 0) {
				result.add(large);
			} else {
				result.add(1l);
			}
		}
		return result;
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
