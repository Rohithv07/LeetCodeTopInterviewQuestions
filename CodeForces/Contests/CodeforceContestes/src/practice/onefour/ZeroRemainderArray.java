/**
 * @author rohithvazhathody
 * @date 9 May 2026
 * Project: CodeforceContestes
 * File: ZeroRemainderArray.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 
 */
public class ZeroRemainderArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			long[] nums = new long[n];
			long k = fastReader.nextLong();
			for (int index = 0; index < n; index++) {
				nums[index] = fastReader.nextLong();
			}
			long minMoves = findMinMoves(nums, k);
			System.out.println(minMoves);
		}
	}

	private static long findMinMoves(long[] nums, long k) {
		int length = nums.length;
		long[] remainder = new long[length];
		Map<Long, Long> freqMap = new HashMap<>();
		long count = 0;
		for (int index = 0; index < length; index++) {
			long r = nums[index] % k;
			if (r == 0) {
				continue;
			}
			remainder[index] = k - r;
			freqMap.put(remainder[index], freqMap.getOrDefault(remainder[index], 0l) + 1);
			count++;
		}
		if (count == 0) {
			return 0;
		}
		long maxFreq = 0;
		long maxVal = -1;
		for (long key : freqMap.keySet()) {
			long freq = freqMap.get(key);
			if ((freq > maxFreq) || (freq == maxFreq && key > maxVal)) {
				maxFreq = freq;
				maxVal = key;
			}
		}
		long result = ((maxFreq - 1) * k) + maxVal + 1;
		return result;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			try {
				while (st == null || !st.hasMoreElements()) {
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

/*
 * 
 * 
 * 8 7 1 8 3 7 5 10 8 9
 * 2 1 1 2 3 1 5 4 2 3
 * 
 *     
 * 
 * 
 * 
 * 
 * 
 * 10 6 8 7 1 8 3 7 5 10 8 9
 * 
 * 2 1 5 2 3 1 5 4 2 3
 * 
 * 1 1 2 2 2 3 3 4 5 5
 * 
 * 5
 * 
 * 2 1 5 3 4
 * 
 * 0->1 1 -> 2 8 7 1 8 3 7 6 10 8 9
 * 
 * 2 -> 3 8 7 1 8 3 7 6 12 8 9
 * 
 * 3 -> 4 8 7 1 8 3 7 6 12 8 12
 * 
 * 
 * 4 -> 5 12 7 1 8 3 7 6 12 8 12
 * 
 * 5 -> 6 12 12 1 8 3 7 6 12 8 12
 * 
 * 6 -> 7 7->8 8->9 9->10 12 12 1 8 12 7 6 12 8 12
 * 
 * 10->11 12 12 1 18 12 7 6 12 8 12
 * 
 * 11 -> 12 12 12 12 18 12 7 6 12 8 12
 * 
 * 12->13 12 12 12 18 12 7 6 12 30 12
 * 
 * 13 -> 14 12 12 12 18 12 30 6 12 30 12
 * 
 * 
 * 
 * 
 * 
 * 
 */