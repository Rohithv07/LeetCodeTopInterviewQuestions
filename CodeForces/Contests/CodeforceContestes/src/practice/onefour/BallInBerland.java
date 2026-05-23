/**
 * @author rohithvazhathody
 * @date 9 May 2026
 * Project: CodeforceContestes
 * File: BallInBerland.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class BallInBerland {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int a = fastReader.nextInt();
			int b = fastReader.nextInt();
			long k = fastReader.nextLong();
			int[] boys = new int[(int)k];
			int[] girls = new int[(int)k];
			for (int index = 0; index < k; index++) {
				boys[index] = fastReader.nextInt();
			}
			for (int index = 0; index < k; index++) {
				girls[index] = fastReader.nextInt();
			}
			long total = findTotal(boys, girls, k, a, b);
			System.out.println(total);
		}
	}

	private static long findTotal(int[] boys, int[] girls, long k, int a, int b) {
		long total = combination(k);
		int [] countB = new int [a];
		int [] countG = new int [b];
		for (int index = 0; index < k; index++) {
			countB[boys[index] - 1] += 1;
			countG[girls[index] - 1] += 1;
		}
		for (int boy : countB) {
			total -= combination(boy);
		}
		for (int girl : countG) {
			total -= combination(girl);
		}
		return total;
	}

	private static long combination(long k) {
		return (k * (k - 1)) / 2;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			try {
				while (st == null || !st.hasMoreElements()) {
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
