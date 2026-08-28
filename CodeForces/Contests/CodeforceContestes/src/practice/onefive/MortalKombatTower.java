/**
 * @author rohithvazhathody
 * @date 25 Jul 2026
 * Project: CodeforceContestes
 * File: MortalKombatTower.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class MortalKombatTower {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int[] nums = new int[n];
			for (int index = 0; index < n; index++) {
				nums[index] = fastReader.nextInt();
			}
			int minimumSkip = findMinimumSkip(nums);
			out.println(minimumSkip);
		}
		out.flush();
		out.close();
	}

	private static int findMinimumSkip(int[] nums) {
		int length = nums.length;
		if (length == 1) {
			return nums[0];
		}
		if (length == 2) {
			int firstBoss = nums[0];
			if (firstBoss == 1) {
				return 1;
			}
			if (firstBoss == 0) {
				return 0;
			}
		}
		int[] dp = new int[length];
		Arrays.fill(dp, -1);
		return calculateMinimumSkip(nums, 0, dp);
	}

	private static int calculateMinimumSkip(int[] nums, int currentIndex, int[] dp) {
		if (currentIndex >= nums.length) {
			return 0;
		}
		if (dp[currentIndex] != -1) {
			return dp[currentIndex];
		}
		int currentBoss = nums[currentIndex];
		int killCurrentBossOnly = currentBoss + Math.min(calculateMinimumSkip(nums, currentIndex + 2, dp),
				calculateMinimumSkip(nums, currentIndex + 3, dp));
		int killBothBoss = (int) (1e9);
		if (currentIndex + 1 < nums.length) {
			int nextBoss = nums[currentIndex + 1];
			killBothBoss = currentBoss + nextBoss + Math.min(calculateMinimumSkip(nums, currentIndex + 3, dp),
					calculateMinimumSkip(nums, currentIndex + 4, dp));
		}
		return dp[currentIndex] = Math.min(killCurrentBossOnly, killBothBoss);
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
