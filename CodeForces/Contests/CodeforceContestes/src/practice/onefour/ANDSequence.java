/**
 * @author rohithvazhathody
 * @date 6 May 2026
 * Project: CodeforceContestes
 * File: ANDSequence.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class ANDSequence {
	
	
	private static final long MOD = (long)(1e9 + 7);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		long [] factorial = new long [200001];
		factorial[0] = 1;
		for (int i = 1; i <= 200000; i++) {
			factorial[i] = (factorial[i - 1] * i) % MOD;
		}
		while (test-- > 0) {
			int n = fastReader.nextInt();
			long [] nums = new long [n];
			for (int index = 0; index < n; index++) {
				nums[index] = fastReader.nextLong();
			}
			long noOfPermutation = findNumberOfPermuation(nums, factorial);
			System.out.println(noOfPermutation);
		}
	}

	private static long findNumberOfPermuation(long[] nums, long[] factorial) {
		long totalAnd = 0;
		totalAnd = nums[0];
		int length = nums.length;
		for (int index = 1; index < length; index++) {
			totalAnd &= nums[index];
		}
		long count = 0;
		for (long num : nums) {
			if (num == totalAnd) {
				count++;
			}
		}
		if (count <= 1) {
			return 0;
		}
		long ways = ((count) * (count - 1)) % MOD;
		ways = (ways * factorial[length - 2]) % MOD;
		return ways;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			try {
				while (st == null || !st.hasMoreElements()) {
					st = new StringTokenizer(br.readLine());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

}
