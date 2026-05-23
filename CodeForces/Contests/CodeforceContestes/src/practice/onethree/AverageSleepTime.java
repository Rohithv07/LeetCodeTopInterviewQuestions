/**
 * @author rohithvazhathody
 * @date 23 Apr 2026
 * Project: CodeforceContestes
 * File: AverageSleepTime.java
 */

package practice.onethree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class AverageSleepTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int n = fastReader.nextInt();
		int k = fastReader.nextInt();
		int [] nums = new int [n];
		for (int index = 0; index < n; index++) {
			nums[index] = fastReader.nextInt();
		}
		double avgSleepTime = findAvg(nums, k);
		System.out.println(avgSleepTime);
	}
	
	private static double findAvg(int[] nums, int k) {
		int length = nums.length;
		int week = length - k + 1;
		long totalSum = 0;
		long windowSum = 0;
		for (int index = 0; index < k; index++) {
			windowSum += nums[index];
		}
		totalSum += windowSum;
		for (int index = k; index < length; index++) {
			windowSum += nums[index] - nums[index - k];
			totalSum += windowSum;
		}
		double avg = (double)(totalSum) / (double)(week);
		return avg;
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
