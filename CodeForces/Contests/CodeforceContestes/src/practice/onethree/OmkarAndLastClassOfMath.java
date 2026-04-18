/**
 * @author rohithvazhathody
 * @date 18 Apr 2026
 * Project: CodeforceContestes
 * File: OmkarAndLastClassOfMath.java
 */

package practice.onethree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class OmkarAndLastClassOfMath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int [] pair = findPair(n);
			System.out.println(pair[0] + " " + pair[1]);
		}
	}

	private static int[] findPair(int n) {
		for (int index = 2; index * index <= n; index++) {
			if (n % index == 0) {
				int val = n / index;
				return new int [] {val, n - val};
			}
		}
		return new int []{1, n - 1};
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
