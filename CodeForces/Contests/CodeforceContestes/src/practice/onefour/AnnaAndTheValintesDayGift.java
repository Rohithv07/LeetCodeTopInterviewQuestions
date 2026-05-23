/**
 * @author rohithvazhathody
 * @date 24 Apr 2026
 * Project: CodeforceContestes
 * File: AnnaAndTheValintesDayGift.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class AnnaAndTheValintesDayGift {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int m = fastReader.nextInt();
			int [] nums = new int [n];
			for (int index = 0; index < n; index++) {
				nums[index] = fastReader.nextInt();
			}
			String winner = findWinner(nums, m);
			System.out.println(winner);
		}
	}
	
	private static String findWinner(int[] nums, int m) {
		int length = nums.length;
		int [] trailingZeros = new int [length];
		int totalDigits = 0;
		int index = 0;
		for (int num : nums) {
			totalDigits += findTotalDigits(num, trailingZeros, index);
			index++;
		}
		Arrays.sort(trailingZeros);
		index = 0;
		for (index = length - 1; index >= 0; index -= 2) {
			totalDigits -= trailingZeros[index];
		}
		return totalDigits <= m ? "Anna" : "Sasha";
	}

	private static int findTotalDigits(int num, int[] trailingZeros, int index) {
		int total = 0;
		while (num % 10 == 0) {
			trailingZeros[index]++;
			num /= 10;
			total++;
		}
		while (num > 0) {
			total++;
			num /= 10;
		}
		return total;
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
