/**
 * @author rohithvazhathody
 * @date 7 Jun 2026
 * Project: CodeforceContestes
 * File: TeaTasting.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class TeaTasting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int[] nums1 = new int[n + 1];
			int[] nums2 = new int[n + 1];
			for (int index = 1; index <= n; index++) {
				nums1[index] = fastReader.nextInt();
			}
			for (int index = 1; index <= n; index++) {
				nums2[index] = fastReader.nextInt();
			}
			long[] totalAmount = findTotalAmountOfTeaTasted(nums1, nums2);
			for (long total : totalAmount) {
				System.out.print(total + " ");
			}
			System.out.println();
		}
	}

	private static long[] findTotalAmountOfTeaTasted(int[] nums1, int[] nums2) {
		int length = nums1.length;
		if (length == 2) {
			long min = Math.min(nums1[1], nums2[1]);
			return new long[] { min };
		}
		long[] result = new long[length - 1];
		long[] prefixB = new long[length + 1];
		for (int index = 1; index < length; index++) {
			prefixB[index] = prefixB[index - 1] + nums2[index];
		}
		long[] fullTesting = new long[length + 2];
		long[] partialTesting = new long[length + 2];
		for (int index = 1; index < length; index++) {
			long target = nums1[index] + prefixB[index - 1];
			int justGreaterThanAI = findGreater(target, index, length - 1, prefixB);
			if (justGreaterThanAI >= index) {
				fullTesting[index]++;
				fullTesting[justGreaterThanAI + 1]--;
			}
			if (justGreaterThanAI + 1 <= length - 1) {
				long usedTea = (justGreaterThanAI >= index) ? prefixB[justGreaterThanAI] - prefixB[index - 1] : 0;
				partialTesting[justGreaterThanAI + 1] += (nums1[index] - usedTea);
			}
		}
		long currentFulls = 0;
		for (int i = 1; i < length; i++) {
			currentFulls += fullTesting[i];
			long ans = (currentFulls * nums2[i]) + partialTesting[i];
			result[i - 1] = ans;
		}
		return result;
	}

	private static int findGreater(long key, int low, int high, long[] prefixB) {
		int answer = low - 1;
		while (low <= high) {
			int middle = low + (high - low) / 2;
			if (prefixB[middle] <= key) {
				answer = middle;
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return answer;
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
