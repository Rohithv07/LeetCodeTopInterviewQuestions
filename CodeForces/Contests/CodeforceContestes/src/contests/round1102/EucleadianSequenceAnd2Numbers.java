/**
 * @author rohithvazhathody
 * @date 7 Jun 2026
 * Project: CodeforceContestes
 * File: EucleadianSequenceAnd2Numbers.java
 */

package contests.round1102;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class EucleadianSequenceAnd2Numbers {

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
			int[] xAndY = findXAndY(nums);
			if (xAndY.length == 1) {
				System.out.println(xAndY[0]);
			} else {
				System.out.println(xAndY[0] + " " + xAndY[1]);
			}
		}
	}

	private static int[] findXAndY(int[] nums) {
		Arrays.sort(nums);
		int length = nums.length;
		for (int index = length - 1; index - 2 >= 0; index--) {
			int a = nums[index];
			int b = nums[index - 1];
			int c = nums[index - 2];
			if ((a % b) != c) {
				return new int[] { -1 };
			}
		}
		return new int[] { nums[length - 1], nums[length - 2] };
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
