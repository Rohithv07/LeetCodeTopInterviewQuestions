/**
 * @author rohithvazhathody
 * @date 23 May 2026
 * Project: CodeforceContestes
 * File: OracAndModels.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class OracAndModels {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int [] nums = new int [n + 1];
			for (int index = 1; index <= n; index++) {
				nums[index] = fastReader.nextInt();
			}
			int maxModels = findMaxModels(nums);
			System.out.println(maxModels);
		}
	}

	private static int findMaxModels(int[] nums) {
		int length = nums.length;
		int max = 0;
		int [] dp = new int [length + 1];
		Arrays.fill(dp,  1);
		for (int i = 1; i < length; i++) {
			for (int j = 1; j * j <= i; j++) {
				if (i % j != 0) {
					continue;
				}
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				int k = i / j;
				if (nums[k] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[k] + 1);
				}
			}
		}
		for (int index = 1; index <= length; index++) {
			max = Math.max(max, dp[index]);
		}
		return max;
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
