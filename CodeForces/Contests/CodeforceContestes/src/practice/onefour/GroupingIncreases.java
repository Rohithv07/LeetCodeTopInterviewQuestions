/**
 * @author rohithvazhathody
 * @date 24 Apr 2026
 * Project: CodeforceContestes
 * File: GroupingIncreases.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class GroupingIncreases {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int[] nums = new int[n];
			for (int index = 0; index < n; index++) {
				nums[index] = fastReader.nextInt();
			}
			int penalty = findPenalty(nums);
			System.out.println(penalty);
		}
	}

	private static int findPenalty(int[] nums) {
		int end1 = Integer.MAX_VALUE;
		int end2 = Integer.MAX_VALUE;
		int penalty = 0;
		for (int num : nums) {
			if (end1 > end2) {
				int temp = end1;
				end1 = end2;
				end2 = temp;
			} if (num <= end1) {
				end1 = num;
			} else if (num <= end2) {
				end2 = num;
			} else {
				penalty++;
				end1 = num;
			}
		}
		return penalty;
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
 * 
 * 1 2 3 4 5
 * 
 * 1 2 3 4 5
 * 
 * 
 * 
 * 
 * 1 2 2 2 2 3 3 3 3 4 5 6
 * 
 * 1 2 2 2 2 3 3 3 3 4 5 6
 * 
 * 
 */
