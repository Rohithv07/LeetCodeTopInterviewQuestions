/**
 * @author rohithvazhathody
 * @date 18 Jul 2026
 * Project: CodeforceContestes
 * File: StepanAndPermutation.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class StepanAndPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int x = fastReader.nextInt();
			int y = fastReader.nextInt();
			int[] nums = new int[n + 1];
			for (int index = 1; index <= n; index++) {
				nums[index] = fastReader.nextInt();
			}
			String sortingPossible = findSortingPossible(nums, x, y);
			out.println(sortingPossible);
		}
		out.flush();
		out.close();
	}

	private static String findSortingPossible(int[] nums, int x, int y) {
		// is already sorted
		boolean isAlreadySorted = true;
		int length = nums.length;
		for (int index = 0; index + 1 < length; index++) {
			if (nums[index] > nums[index + 1]) {
				isAlreadySorted = false;
				break;
			}
		}
		if (isAlreadySorted) {
			return "YES";
		}
		int gcd = findGCD(x, y);
		// even number in odd position moves ot even position if x or y is odd
		// odd number in even posiition moves to odd position if x or y is odd
		for (int index = 1; index < length; index++) {
			int currentNum = nums[index];
			if (currentNum % gcd != index % gcd) {
				return "NO";
			}
		}
		return "YES";
	}

	private static int findGCD(int x, int y) {
		if (y == 0) {
			return x;
		}
		return findGCD(y, x % y);
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
