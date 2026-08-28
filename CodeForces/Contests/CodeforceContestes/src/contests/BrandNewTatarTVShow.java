/**
 * @author rohithvazhathody
 * @date 19 Jul 2026
 * Project: CodeforceContestes
 * File: BrandNewTatarTVShow.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 
 */
public class BrandNewTatarTVShow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int k = fastReader.nextInt();
			int[] nums = new int[n];
			for (int index = 0; index < n; index++) {
				nums[index] = fastReader.nextInt();
			}
			String possibleToWin = findPossibleToWin(nums, k);
			out.println(possibleToWin);
		}

		out.flush();
		out.close();
	}

	private static String findPossibleToWin(int[] nums, int k) {
		int length = nums.length;
		if (length == 1) {
			return "NO";
		}
//		if (length == 2) {
//			return "YES";
//		}
		Arrays.sort(nums);
//		if (nums[0] == nums[length - 1]) {
//			if (length % 2 == 1) {
//				return "NO";
//			}
//			return "YES";
//		}
//		int countOfMax = 0;
//		int index = length - 1;
//		while (index - 1 >= 0 && nums[index] == nums[index - 1]) {
//			countOfMax++;
//			index--;
//		}
//		if (countOfMax % 2 == 0) {
//			return "YES";
//		}
		TreeMap<Integer, Integer> freqMap = new TreeMap<>(Collections.reverseOrder());
		for (int num : nums) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}
		int winningValRange = Integer.MAX_VALUE;
		boolean doesHeWin = false;
		for (Integer key : freqMap.keySet()) {
			int count = freqMap.get(key);
			if (key <= winningValRange) {
				if (count % 2 == 0) {
					doesHeWin = true;
					break;
				} else {
					winningValRange = key - k - 1;
				}
			} else {
				doesHeWin = true;
				break;
			}
		}
		return doesHeWin ? "YES" : "NO";
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
