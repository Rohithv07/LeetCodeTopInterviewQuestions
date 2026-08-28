/**
 * @author rohithvazhathody
 * @date 9 Aug 2026
 * Project: CodeforceContestes
 * File: ThreeNumbersOfBlackBoard.java
 */

package contests.round1116;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class ThreeNumbersOfBlackBoard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = 3;
			int [] nums = new int [n];
			for (int index = 0; index < n; index++) {
				nums[index] = fastReader.nextInt();
			}
			Arrays.sort(nums);
			int op1 = nums[2] - nums[0];
			int op2 = nums[1];
			out.println(Math.min(op1, op2));
		}
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
