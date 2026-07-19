/**
 * @author rohithvazhathody
 * @date 12 Jul 2026
 * Project: CodeforceContestes
 * File: FactorialsAndPowerOf2.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 */
public class FactorialsAndPowerOf2 {
	static ArrayList<Long> factorials = new ArrayList<>();

	static {
		long fact = 6; // 3!
		long i = 4;
		while (fact <= 1000000000000L) {
			factorials.add(fact);
			fact *= i;
			i++;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			long n = fastReader.nextLong();
			long totalK = findTotalK(n);
			out.println(totalK);
		}
		out.flush();
		out.close();
	}

	private static long findTotalK(long n) {
		int size = factorials.size();
		int totalMasks = 1 << size;
		long minTerms = Long.bitCount(n);

		// Iterate over all possible subsets of factorials
		for (int mask = 1; mask < totalMasks; mask++) {
			long currentSum = 0;
			int count = 0;

			for (int j = 0; j < size; j++) {
				if ((mask & (1 << j)) != 0) {
					currentSum += factorials.get(j);
					count++;
				}
			}

			if (currentSum <= n) {
				long remainder = n - currentSum;
				long totalTerms = count + Long.bitCount(remainder);
				minTerms = Math.min(minTerms, totalTerms);
			}
		}
		return minTerms;
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
