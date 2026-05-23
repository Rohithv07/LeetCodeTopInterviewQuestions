/**
 * @author rohithvazhathody
 * @date 25 Apr 2026
 * Project: CodeforceContestes
 * File: ArrayGame.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */
public class ArrayGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int k = fastReader.nextInt();
			long[] nums = new long[n];
			for (int index = 0; index < n; index++) {
				nums[index] = fastReader.nextLong();
			}
			long minValue = findMinValue(nums, k);
			System.out.println(minValue);
		}
	}

	private static long findMinValue(long[] nums, int k) {
		if (k >= 3) {
			return 0;
		}
		int length = nums.length;
		long min = Long.MAX_VALUE;
		List<Long> difference = new ArrayList<>();
		for (int index1 = 0; index1 < length; index1++) {
			min = Math.min(min, nums[index1]);
			for (int index2 = index1 + 1; index2 < length; index2++) {
				long abs = Math.abs(nums[index1] - nums[index2]);
				difference.add(abs);
			}
		}
		Collections.sort(difference);
		long answer = Math.min(min, difference.get(0));
		if (k == 2) {
			for (int index = 0; index < length; index++) {
				long currentNum = nums[index];
				int nearest = findNearest(difference, 0, difference.size() - 1, currentNum);
				if (nearest < difference.size()) {
					answer = Math.min(answer, Math.abs(difference.get(nearest) - currentNum));
				}
				if (nearest - 1 >= 0) {
					answer = Math.min(answer, Math.abs(difference.get(nearest - 1) - currentNum));
				}
			}
		}
		return answer;
	}

	private static int findNearest(List<Long> difference, int low, int high, long key) {
		while (low < high) {
			int middle = low + (high - low) / 2;
			if (difference.get(middle) < key) {
				low = middle + 1;
			} else {
				high = middle;
			}
		}
		return low;
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
