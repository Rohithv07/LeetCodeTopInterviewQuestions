/**
 * @author rohithvazhathody
 * @date 18 Apr 2026
 * Project: CodeforceContestes
 * File: MostSociallyDistancedSubsequence.java
 */

package practice.onethree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */
public class MostSociallyDistancedSubsequence {

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
			List<Integer> sequence = findSubsequence(nums);
			System.out.println(sequence.size());
			for (Integer val : sequence) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

	private static List<Integer> findSubsequence(int[] nums) {
		// find the extreme min/max and repeat it
		int length = nums.length;
		List<Integer> result = new ArrayList<>();
		result.add(nums[0]);
		for (int index = 1; index < length - 1; index++) {
			boolean isPeak = nums[index] > nums[index - 1] && nums[index] > nums[index + 1];
			boolean isValley = nums[index] < nums[index - 1] && nums[index] < nums[index + 1];
			if (isPeak || isValley) {
				result.add(nums[index]);
			}

		}
		result.add(nums[length - 1]);
		return result;
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
