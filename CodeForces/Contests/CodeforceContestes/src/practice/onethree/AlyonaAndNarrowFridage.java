/**
 * @author rohithvazhathody
 * @date 19 Apr 2026
 * Project: CodeforceContestes
 * File: AlyonaAndNarrowFridage.java
 */

package practice.onethree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */
public class AlyonaAndNarrowFridage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int n = fastReader.nextInt();
		int h = fastReader.nextInt();
		int[] nums = new int[n];
		for (int index = 0; index < n; index++) {
			nums[index] = fastReader.nextInt();
		}
		long largestK = findLargestK(nums, h);
		System.out.println(largestK);
	}

	private static long findLargestK(int[] nums, int h) {
		long low = 0;
		long high = nums.length - 1;
		long result = -1;
		while (low <= high) {
			long middle = low + (high - low) / 2;
			List<Integer> temp = new ArrayList<>();
			for (int index = 0; index <= middle; index++) {
				temp.add(nums[index]);
			}
			Collections.sort(temp);
			long height = 0;
			long pointer = middle;
			while (pointer >= 0) {
				height += temp.get((int) pointer);
				pointer -= 2;
				if (height > h) {
					break;
				}
			}
			if (height > h) {
				high = middle - 1;
			} else {
				result = middle;
				low = middle + 1;
			}
		}
		return result + 1;
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
