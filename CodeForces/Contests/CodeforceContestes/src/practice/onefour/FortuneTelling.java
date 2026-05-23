/**
 * @author rohithvazhathody
 * @date 3 May 2026
 * Project: CodeforceContestes
 * File: FortuneTelling.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class FortuneTelling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			long x = fastReader.nextLong();
			long y = fastReader.nextLong();
			long [] nums = new long [n];
			for (int index = 0; index < n; index++) {
				nums[index] = fastReader.nextLong();
			}
			String who = findWho(x, x + 3, y, nums);
			System.out.println(who);
		}
	}
	
	private static String findWho(long alice, long bob, long y, long[] nums) {
		long sum = Arrays.stream(nums).sum();
		if ((sum + alice + y) % 2 == 0) {
			return "Alice";
		}
		return "Bob";
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
