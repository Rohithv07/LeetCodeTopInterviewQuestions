/**
 * @author rohithvazhathody
 * @date 6 Jun 2026
 * Project: CodeforceContestes
 * File: BlockSequence.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class BlockSequence {

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
			int minRemoval = findMinRemoval(nums);
			System.out.println(minRemoval);
		}
	}

	private static int findMinRemoval(int[] nums) {
		int length = nums.length;
		if (nums[0] == length - 1) {
			return 0;
		}
		int[] dp = new int[length];
		Arrays.fill(dp, -1);
		return findMin(nums, 0, dp);
	}

	private static int findMin(int[] nums, int i, int[] dp) {
		if (i == nums.length) {
			return 0;
		}
		if (dp[i] != -1) {
			return dp[i];
		}
		int delete = 1 + findMin(nums, i + 1, dp);
		int keep = Integer.MAX_VALUE;
		if (i + nums[i] < nums.length) {
			keep = findMin(nums, i + nums[i] + 1, dp);
		}
		return dp[i] = Math.min(delete, keep);
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
