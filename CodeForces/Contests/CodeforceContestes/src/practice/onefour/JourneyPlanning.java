/**
 * @author rohithvazhathody
 * @date 24 May 2026
 * Project: CodeforceContestes
 * File: JourneyPlanning.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 
 */
public class JourneyPlanning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int n = fastReader.nextInt();
		int[] nums = new int[n];
		for (int index = 0; index < n; index++) {
			nums[index] = fastReader.nextInt();
		}
		long maxBeauty = findMaxBeauty(nums);
		System.out.println(maxBeauty);
	}

	private static long findMaxBeauty(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		long maxBeauty = 0;
		int length = nums.length;
		Map<Integer, Long> indexMap = new HashMap<>();
		for (int index = 0; index < length; index++) {
			int key = index - nums[index];
			long val = indexMap.getOrDefault(key, 0L) + nums[index];
			indexMap.put(key, val);
		}
		for (int key : indexMap.keySet()) {
			maxBeauty = Math.max(maxBeauty, indexMap.get(key));
		}
		return maxBeauty;
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
