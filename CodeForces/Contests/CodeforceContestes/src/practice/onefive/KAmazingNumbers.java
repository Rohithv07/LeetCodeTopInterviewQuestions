/**
 * @author rohithvazhathody
 * @date 25 Jul 2026
 * Project: CodeforceContestes
 * File: KAmazingNumbers.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 
 */
public class KAmazingNumbers {

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
			int[] minSub = findMinSub(nums);
			for (int index = 1; index <= n; index++) {
				out.print(minSub[index] + " ");
			}
			out.println();
		}
		out.flush();
		out.close();
	}

	private static int[] findMinSub(int[] nums) {
		// gap from start
		// gap from end
		// gap between repeating elements
		// track the maximum
		// minimum numbers who can sit in that gap will be the answer
		int length = nums.length;
		int[] result = new int[length + 1];
		Arrays.fill(result, -1);
		int[] maxGap = new int[length + 1];
		Map<Integer, Integer> lastSeenIndex = new HashMap<>();
		// start and repetition
		for (int index = 0; index < length; index++) {
			int currentNum = nums[index];
			int lastIndex = lastSeenIndex.getOrDefault(currentNum, -1);
			int currentGap = index - lastIndex;
			maxGap[currentNum] = Math.max(maxGap[currentNum], currentGap);
			lastSeenIndex.put(currentNum, index);
		}
		// end
		for (int key : lastSeenIndex.keySet()) {
			int lastIndex = lastSeenIndex.get(key);
			int lastGap = length - lastIndex;
			maxGap[key] = Math.max(maxGap[key], lastGap);
		}
		for (int num = 1; num <= length; num++) {
			int currentGap = maxGap[num];
			if (currentGap > 0) {
				if (result[currentGap] == -1 || num < result[currentGap]) {
					result[currentGap] = num;
				}
			}
		}
		for (int window = 2; window <= length; window++) {
			if (result[window - 1] != -1) {
				if (result[window] == -1 || result[window] > result[window - 1]) {
					result[window] = result[window - 1];
				}
			}
		}
		return result;
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
