/**
 * @author rohithvazhathody
 * @date 14 Jul 2026
 * Project: CodeforceContestes
 * File: AgagaXOOR.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class AgagaXOOR {

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
			String possible = isPossible(nums);
			out.println(possible);
		}
		out.flush();
		out.close();
	}

	private static String isPossible(long[] nums) {
		// check if totalxro = 0;
		long totalXOR = 0;
		// else check if there is any prefixxor == suffixor
		long prefixXOR = 0;
		long suffixXOR = 0;
		long prefixIndex = -1;
		long suffixIndex = -1;
		for (long num : nums) {
			totalXOR ^= num;
		}
		if (totalXOR == 0) {
			return "YES";
		}
		for (int index = 0; index < nums.length; index++) {
			long frontNum = nums[index];
			prefixXOR ^= frontNum;
			if (prefixXOR == totalXOR && prefixIndex == -1) {
				prefixIndex = index;
				break;
			}
		}
		for (int index = nums.length - 1; index >= 0; index--) {
			long backNum = nums[index];
			suffixXOR ^= backNum;
			if (suffixXOR == totalXOR && suffixIndex == -1) {
				suffixIndex = index;
				break;
			}
		}
		return suffixIndex > prefixIndex ? "YES" : "NO";
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
