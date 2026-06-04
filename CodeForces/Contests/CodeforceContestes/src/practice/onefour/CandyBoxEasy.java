/**
 * @author rohithvazhathody
 * @date 29 May 2026
 * Project: CodeforceContestes
 * File: CandyBoxEasy.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class CandyBoxEasy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int q = fastReader.nextInt();
		while (q-- > 0) {
			int n = fastReader.nextInt();
			int[] nums = new int[n];
			for (int index = 0; index < n; index++) {
				nums[index] = fastReader.nextInt();
			}
			int size = findMaxSize(nums);
			System.out.println(size);
		}
	}

	private static int findMaxSize(int[] nums) {
		int length = nums.length;
		int maxSize = 0;
		int[] freq = new int[length + 1];
		for (int num : nums) {
			freq[num]++;
		}
		Arrays.sort(freq);
		int lastUsed = Integer.MAX_VALUE;
		for (int index = length; index > 0 && lastUsed > 0; index--) {
			int currentFreq = freq[index];
			if (currentFreq >= lastUsed) {
				maxSize += lastUsed - 1;
				lastUsed--;
			} else {
				maxSize += currentFreq;
				lastUsed = currentFreq;
			}
		}
		return maxSize;
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
 * 16 2 1 3 3 4 3 4 4 1 3 2 2 2 4 1 1
 * 
 * 1 -> 4 2 -> 4 3 -> 4 4 -> 4
 * 
 * 
 * 9 2 2 4 4 4 7 7 7 7
 * 
 * 2 -> 2 4 -> 3 7 -> 4
 * 
 * 
 * 8 1 4 8 4 5 6 3 8
 * 
 * 1 -> 1 3 -> 1 4 -> 2 5 -> 1 6 -> 1 8 -> 2
 * 
 * 
 * 
 * 
 * 
 */
