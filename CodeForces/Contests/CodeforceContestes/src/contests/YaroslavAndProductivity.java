/**
 * @author rohithvazhathody
 * @date 18 Jul 2026
 * Project: CodeforceContestes
 * File: YaroslavAndProductivity.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class YaroslavAndProductivity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int m = fastReader.nextInt();
			long[] nums1 = new long[n];
			long[] nums2 = new long[m];
			for (int index = 0; index < n; index++) {
				nums1[index] = fastReader.nextLong();
			}
			for (int index = 0; index < m; index++) {
				nums2[index] = fastReader.nextLong();
			}
			long maxProductivity = findMaxProductivity(nums1, nums2);
			out.println(maxProductivity);
		}
		out.flush();
		out.close();
	}

	private static long findMaxProductivity(long[] nums1, long[] nums2) {
		int length1 = nums1.length;
		int length2 = nums2.length;

		boolean[] boundary = new boolean[length1 + 1];
		int maxB = 0;

		for (int index = 0; index < length2; index++) {
			boundary[(int) nums2[index]] = true;
			maxB = (int) Math.max(maxB, nums2[index]);
		}

		long total = 0;
		long currentSum = 0;

		for (int index = 0; index < maxB; index++) {
			currentSum += nums1[index];

			if (boundary[index + 1]) {
				total += Math.abs(currentSum);
				currentSum = 0;
			}
		}

		for (int index = maxB; index < length1; index++) {
			total += nums1[index];
		}

		return total;
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
