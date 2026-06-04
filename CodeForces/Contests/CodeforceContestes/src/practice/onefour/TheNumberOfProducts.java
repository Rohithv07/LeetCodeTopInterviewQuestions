/**
 * @author rohithvazhathody
 * @date 24 May 2026
 * Project: CodeforceContestes
 * File: TheNumberOfProducts.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class TheNumberOfProducts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int n = fastReader.nextInt();
		long[] nums = new long[n];
		for (int index = 0; index < n; index++) {
			nums[index] = fastReader.nextLong();
		}
		long[] counts = findCounts(nums);
		System.out.println(counts[0] + " " + counts[1]);
	}

	private static long[] findCounts(long[] nums) {
		int length = nums.length;
		long odd = 0;
		long even = 1;
		long oddOrEven = 0;
		long result = 0;
		for (long num : nums) {
			if (num < 0) {
				oddOrEven = 1 - oddOrEven;
			}
			if (oddOrEven == 0) {
				result += even;
				even++;
			} else {
				result += odd;
				odd++;
			}
		}
		long total = ((long)length * ((long)length + 1)) / 2;

		return new long[] { total - result, result };
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
