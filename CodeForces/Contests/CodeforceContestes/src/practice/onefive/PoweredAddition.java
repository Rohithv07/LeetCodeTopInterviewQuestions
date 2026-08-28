/**
 * @author rohithvazhathody
 * @date 11 Aug 2026
 * Project: CodeforceContestes
 * File: PoweredAddition.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class PoweredAddition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			long[] nums = new long[n];
			for (int index = 0; index < n; index++) {
				nums[index] = fastReader.nextLong();
			}
			long smallestT = findSmallestT(nums);
			out.println(smallestT);
		}
		out.flush();
		out.close();
	}

	private static long findSmallestT(long[] nums) {
		long max = 0;
		for (int index = 1; index < nums.length; index++) {
			if (nums[index] < nums[index - 1]) {
				max = Math.max(max, nums[index - 1] - nums[index]);
				nums[index] = nums[index - 1];
			}
		}
		if (max == 0) {
			return 0;
		}
		return (long) (Math.log(max) / Math.log(2)) + 1;
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
