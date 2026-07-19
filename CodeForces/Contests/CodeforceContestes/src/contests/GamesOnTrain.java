/**
 * @author rohithvazhathody
 * @date 19 Jul 2026
 * Project: CodeforceContestes
 * File: GamesOnTrain.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class GamesOnTrain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int[] nums = new int[n];
			for (int index = 0; index < n; index++) {
				nums[index] = fastReader.nextInt();
			}
			int smallestK = findSmallestK(nums);
			out.println(smallestK);
		}
		out.flush();
		out.close();
	}

	private static int findSmallestK(int[] nums) {
		int largest = Arrays.stream(nums).max().getAsInt();
		int smallest = Arrays.stream(nums).min().getAsInt();
		return largest - smallest + 1;
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
