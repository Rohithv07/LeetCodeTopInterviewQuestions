/**
 * @author rohithvazhathody
 * @date 24 Nov 2026
 * Project: CodeforceContestes
 * File: Pride.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class Pride {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = 1;
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int[] nums = new int[n];
			for (int index = 0; index < n; index++) {
				nums[index] = fastReader.nextInt();
			}
			int minOperation = findMinOperation(nums);
			out.println(minOperation);
		}
		out.flush();
		out.close();
	}

	private static int findMinOperation(int[] nums) {
		int length = nums.length;
		int totalGCD = nums[0];
		int oneCount = 0;
		for (int num : nums) {
			totalGCD = findGcd(totalGCD, num);
			if (num == 1) {
				oneCount++;
			}
		}
		if (totalGCD > 1) {
			return -1;
		}
		if (oneCount > 0) {
			return length - oneCount;
		}
		int minOperation = Integer.MAX_VALUE;
		for (int index = 0; index < length; index++) {
			int currentGCD = nums[index];
			for (int next = index + 1; next < length; next++) {
				currentGCD = findGcd(currentGCD, nums[next]);
				if (currentGCD == 1) {
					minOperation = Math.min(minOperation, (length - 1) + (next - index));
					break;
				}
			}
		}
		return minOperation;
	}

	private static Integer findGcd(int ele, int i) {
		if (i == 0) {
			return ele;
		}
		return findGcd(i, ele % i);
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			try {
				while (st == null || !st.hasMoreTokens()) {
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
