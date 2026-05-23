/**
 * @author rohithvazhathody
 * @date 2 May 2026
 * Project: CodeforceContestes
 * File: ScheduleManagement.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class ScheduleManagement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int m = fastReader.nextInt();
			int[] nums = new int[m];
			for (int index = 0; index < m; index++) {
				nums[index] = fastReader.nextInt();
			}
			int minimumTime = findMinimumTime(nums, n);
			System.out.println(minimumTime);
		}
	}

	private static int findMinimumTime(int[] nums, int n) {
		int[] frequency = new int[n + 1];
		for (int num : nums) {
			frequency[num]++;
		}
		int low = 0;
		int high = (int)(1e9);
		int result = -1;
		while (low <= high) {
			int middle = low + (high - low) / 2;
			if (isPossible(frequency, n, middle, nums.length)) {
				result = middle;
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return result;
	}

	private static boolean isPossible(int[] frequency, int n, int middle, int m) {
		long amount = 0;
		for (int index = 1; index <= n; index++) {
			int currentFreq = frequency[index];
			if (currentFreq > middle) {
				amount += middle;
			} else {
				amount += currentFreq + ((middle - currentFreq) / 2);
			}
		}
		return amount >= m;
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

/*
 * 
 * val = 1
 * 
 * 1 1 2 2
 * 
 * 
 * 2
 * 
 * 2 =
 * 
 * 
 * 
 * 
 * 
 */
