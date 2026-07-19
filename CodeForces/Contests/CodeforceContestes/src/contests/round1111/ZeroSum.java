/**
 * @author rohithvazhathody
 * @date 18 Jul 2026
 * Project: CodeforceContestes
 * File: ZeroSum.java
 */

package contests.round1111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class ZeroSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int[] nums = new int[n];
			for (int index = 0; index < n; index++) {
				nums[index] = fastReader.nextInt();
			}
			String possible = findPossible(nums);
			System.out.println(possible);
		}
	}

	private static String findPossible(int[] nums) {
		int length = nums.length;
		if (length == 1) {
			return "NO";
		}
		int countNegative = 0;
		int totalSum = 0;
		for (int num : nums) {
			if (num != 1) {
				countNegative++;
			}
			totalSum += num;
		}
//		if (countNegative == 0 || countNegative == length) {
//			return "NO";
//		}
		if (length % 2 == 1) {
			return "NO";
		}

		return totalSum % 4 == 0 ? "YES" : "NO";
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
