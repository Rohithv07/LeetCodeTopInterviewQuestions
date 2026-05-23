/**
 * @author rohithvazhathody
 * @date 29 Apr 2026
 * Project: CodeforceContestes
 * File: IvaAndPav.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class IvaAndPav {

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
			int queryLength = fastReader.nextInt();
			for (int index = 0; index < queryLength; index++) {
				int l = fastReader.nextInt();
				int k = fastReader.nextInt();
				int r = findUpperBound(nums, l, k);
				System.out.print(r + " ");
			}
			System.out.println();
		}
	}

	private static int findUpperBound(int[] nums, int l, int k) {
		
		return 0;
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
 * 
 * 15 14 17 42 34
 * 
 * 15 14 0 0 0
 * 
 * 1, 7 -> 2
 * 
 * 2,15 -> -1
 * 4,5 -> 5
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
