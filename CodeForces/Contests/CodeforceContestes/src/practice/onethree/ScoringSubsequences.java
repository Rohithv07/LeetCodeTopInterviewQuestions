/**
 * @author rohithvazhathody
 * @date 28 Feb 2026
 * Project: CodeforceContestes
 * File: ScoringSubsequences.java
 */

package practice.onethree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class ScoringSubsequences {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int[] nums = new int[n];
			for (int index = 0; index < n; index++) {
				nums[index] = fastReader.nextInt();
			}
			int[] score = findScore(nums);
			for (int sc : score) {
				System.out.print(sc + " ");
			}
			System.out.println();
		}
	}

	private static int[] findScore(int[] nums) {
		int length = nums.length;
		int[] result = new int[length];
		for (int index = 0; index < length; index++) {
			int maxLength = findMaxLength(nums, 1, index + 1, index);
			result[index] = maxLength;
		}
		return result;
	}

	private static int findMaxLength(int[] nums, int left, int right, int fixed) {
		while (left <= right) {
			int middle = left + (right - left) / 2;
			if (nums[fixed - middle + 1] >= middle) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return right;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		// Reads the next word (separated by spaces or newlines)
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		// Reads the next integer
		int nextInt() {
			return Integer.parseInt(next());
		}

		// Reads the next long
		long nextLong() {
			return Long.parseLong(next());
		}

		// Reads the next double
		double nextDouble() {
			return Double.parseDouble(next());
		}

		// Reads an entire line
		String nextLine() {
			String str = "";
			try {
				if (st != null && st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}

/*
 * 
 * 5 5 5 5 5
 * 
 * 5 -> 5/1 = 5
 * 
 * 5, 5 -> 5*5/2 = 5/4
 * 
 * 5,5,5, -> 5*5*5/3
 * 
 * 
 * 
 * 1 2 3
 * 
 * 1 -> 1/1 = 1
 * 
 * 1,2 -> 1 and 1,2 _> 2/2 = 1
 * 
 * 1,2,3 -> 1 and 1,2 and 1,2,3 and 2,3
 * 
 * 
 * 
 * 1 2 6
 * 
 * 
 */
