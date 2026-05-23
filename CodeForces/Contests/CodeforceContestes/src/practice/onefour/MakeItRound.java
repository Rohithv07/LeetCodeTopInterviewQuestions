/**
 * @author rohithvazhathody
 * @date 1 May 2026
 * Project: CodeforceContestes
 * File: MakeItRound.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class MakeItRound {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int m = fastReader.nextInt();
			long roundPrice = findRoundPrice(n, m);
			System.out.println(roundPrice);
		}
	}

	private static long findRoundPrice(int n, int m) {
		int temp = n;
		int twoCount = 0;
		int fiveCount = 0;
		while (temp > 0 && temp % 2 == 0) {
			temp /= 2;
			twoCount++;
		}
		temp = n;
		while (temp > 0 && temp % 5 == 0) {
			temp /= 5;
			fiveCount++;
		}
		for (int zero = 18; zero > 0; zero--) {
			int remainingTwo = Math.max(0, zero - twoCount);
			int remainingFive = Math.max(0, zero - fiveCount);
			long calculate = (long) (Math.pow(2, remainingTwo)) * (long) (Math.pow(5, remainingFive));
			if (calculate <= m) {
				long largest = m - (m % calculate);
				return 1L * n * largest;
			}
		}
		return 1L * n * m;
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
