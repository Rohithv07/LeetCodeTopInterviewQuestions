/**
 * @author rohithvazhathody
 * @date 19 Apr 2026
 * Project: CodeforceContestes
 * File: JustEatIt.java
 */

package practice.onethree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class JustEatIt {

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
			String yasserHappy = findYasserHappy(nums);
			System.out.println(yasserHappy);
		}
	}

	private static String findYasserHappy(int[] nums) {
		long yasserTasty = 0;
		long currentSum = 0;
		long maximumSum = Long.MIN_VALUE;
		for (int num : nums) {
			yasserTasty += num;
		}
		for (int index = 0; index < nums.length - 1; index++) {
			int currentNum = nums[index];
			currentSum += currentNum;
			maximumSum = Math.max(maximumSum, currentSum);
			if (currentSum < 0) {
				currentSum = 0;
			}
		}
		currentSum = 0;
		for (int index = 1; index < nums.length; index++) {
			int currentNum = nums[index];
			currentSum += currentNum;
			maximumSum = Math.max(maximumSum, currentSum);
			if (currentSum < 0) {
				currentSum = 0;
			}
		}
		return maximumSum >= yasserTasty ? "NO" : "YES";
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
