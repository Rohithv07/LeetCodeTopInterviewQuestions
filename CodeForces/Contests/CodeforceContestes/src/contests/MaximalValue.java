/**
 * @author rohithvazhathody
 * @date 25 Jul 2026
 * Project: CodeforceContestes
 * File: MaximalValue.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class MaximalValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int n = fastReader.nextInt();
		int[] nums = new int[n];
		for (int index = 0; index < n; index++) {
			nums[index] = fastReader.nextInt();
		}
		int count = 0;
		for (int index = 1; index + 1 < n; index++) {
			if (nums[index - 1] < nums[index] && nums[index] > nums[index + 1]) {
				count++;
			}
		}
		out.println(count);
		out.flush();
		out.close();
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
