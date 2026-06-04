/**
 * @author rohithvazhathody
 * @date 1 Jun 2026
 * Project: CodeforceContestes
 * File: Tape.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class Tape {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int n = fastReader.nextInt();
		long m = fastReader.nextLong();
		long k = fastReader.nextLong();
		long[] segments = new long[n];
		for (int index = 0; index < n; index++) {
			segments[index] = fastReader.nextInt();
		}
		long minTotalLength = findMinTotalLength(m, k, segments);
		System.out.println(minTotalLength);
	}

	private static long findMinTotalLength(long m, long k, long[] segments) {
		int length = segments.length;
		long[] diff = new long[length - 1];
		for (int index = 1; index < length; index++) {
			long currentDiff = segments[index] - segments[index - 1] - 1;
			diff[index - 1] = currentDiff;
		}
		Arrays.sort(diff);
		int limit = length - (int) k;
		long totalCost = length;
		for (int index = 0; index < limit; index++) {
			totalCost += diff[index];
		}
		return totalCost;
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

/*
 * 
 * 4 100 2 20 30 75 80
 * 
 * 9 44 4
 * 
 * 4 9 44
 * 
 * 
 * 
 */
