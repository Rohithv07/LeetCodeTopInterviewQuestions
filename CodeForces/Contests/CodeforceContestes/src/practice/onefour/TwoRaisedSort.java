/**
 * @author rohithvazhathody
 * @date 2 May 2026
 * Project: CodeforceContestes
 * File: TwoRaisedSort.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class TwoRaisedSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int k = fastReader.nextInt();
			long[] nums = new long[n + 1];
			for (int index = 1; index <= n; index++) {
				nums[index] = fastReader.nextLong();
			}
			long count = findNumberOfIndices(nums, k);
			System.out.println(count);
		}
	}

	private static long findNumberOfIndices(long[] nums, int k) {
		int length = nums.length;
		long count = 0;
		long consecutive = 0;
		for (int index = 1; index < length - 1; index++) {
			long currentNum = nums[index];
			long nextNum = nums[index + 1];
			if (currentNum < 2 * nextNum) {
				consecutive++;
			} else {
				consecutive = 0;
			}
			if (consecutive >= k) {
				count++;
			}
		}
		return count;
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
