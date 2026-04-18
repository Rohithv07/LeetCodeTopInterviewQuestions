/**
 * @author rohithvazhathody
 * @date 18 Apr 2026
 * Project: CodeforceContestes
 * File: BuyingShovels.java
 */

package practice.onethree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class BuyingShovels {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			long n = fastReader.nextLong();
			long m = fastReader.nextLong();
			long minPackage = findMinPackage(n, m);
			System.out.println(minPackage);
		}
	}

	private static long findMinPackage(long n, long m) {
		long ans = n;
		for (long num = 1; num * num <= n; num++) {
			if (num > m) {
				break;
			}
			if (n % num == 0) {
				ans = Math.min(ans, n / num);
				if (n / num <= m) {
					ans = Math.min(ans, num);
				}
			}
		}
		return ans;
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
