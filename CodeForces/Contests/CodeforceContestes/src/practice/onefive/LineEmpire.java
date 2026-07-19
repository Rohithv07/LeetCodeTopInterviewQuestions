/**
 * @author rohithvazhathody
 * @date 5 Jul 2026
 * Project: CodeforceContestes
 * File: LineEmpire.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class LineEmpire {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			long a = fastReader.nextInt();
			long b = fastReader.nextInt();
			long[] nums = new long[n + 1];
			for (int index = 1; index <= n; index++) {
				nums[index] = fastReader.nextLong();
			}
			long minCost = findMinCost(nums, a, b);
			out.println(minCost);
		}
		out.flush();
		out.close();
	}

	private static long findMinCost(long[] nums, long a, long b) {
		int length = nums.length;
		long minCost = Long.MAX_VALUE;
		long[] suffixSum = new long[length];
		suffixSum[length - 1] = nums[length - 1];
		for (int index = length - 2; index >= 0; index--) {
			suffixSum[index] = suffixSum[index + 1] + nums[index];
		}

		/*
		 * 
		 * xi * (a + b)b + (b * (suffixSum After xi) - (n-i) * (xi)
		 */

		for (int index = 0; index < length; index++) {
			long val = (nums[index] * (a + b)) + b * (suffixSum[index] - (length - index) * nums[index]);
			minCost = Math.min(minCost, val);
		}
		return minCost;
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
