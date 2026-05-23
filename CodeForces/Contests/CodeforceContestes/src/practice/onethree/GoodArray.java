/**
 * @author rohithvazhathody
 * @date 22 Apr 2026
 * Project: CodeforceContestes
 * File: GoodArray.java
 */

package practice.onethree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 
 */
public class GoodArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int n = fastReader.nextInt();
		int[] nums = new int[n];
		for (int index = 0; index < n; index++) {
			nums[index] = fastReader.nextInt();
		}
		List<Integer> removals = findRemovals(nums);
		if (removals.size() == 0) {
			System.out.println(0);
		} else {
			System.out.println(removals.size());
			for (int num : removals) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	private static List<Integer> findRemovals(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int length = nums.length;
		long[] prefix = new long[length];
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int index = 0; index < length; index++) {
			int num = nums[index];
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
			prefix[index] = index == 0 ? nums[index] : prefix[index - 1] + nums[index];
		}
		for (int index = 0; index < length; index++) {
			int currentNum = nums[index];
			long remainingSum = prefix[length - 1] - currentNum;
			freqMap.put(currentNum, freqMap.get(currentNum) - 1);
			if (remainingSum % 2 == 0 && remainingSum / 2 <= 1000000 && freqMap.containsKey((int)remainingSum / 2) && freqMap.get((int)remainingSum / 2) > 0) {
				result.add(index + 1);
			}
			freqMap.put(currentNum, freqMap.get(currentNum) + 1);
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

/*
 * 5 2 5 1 2 2 5 1 2 2
 * 
 * 2 2 2 5 1 3 5 7 12 2 4 6 11
 * 
 * 1 2 2 2 5
 * 
 * 1 3 5 10
 * 
 * 
 * 
 * 
 * 
 */
