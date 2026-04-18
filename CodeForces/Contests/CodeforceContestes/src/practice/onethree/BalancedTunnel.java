/**
 * @author rohithvazhathody
 * @date 19 Apr 2026
 * Project: CodeforceContestes
 * File: BalancedTunnel.java
 */

package practice.onethree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class BalancedTunnel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int n = fastReader.nextInt();
		int[] entry = new int[n];
		int[] exit = new int[n];
		int[] exitIndex = new int[n + 1];
		for (int index = 0; index < n; index++) {
			entry[index] = fastReader.nextInt();
		}
		for (int index = 0; index < n; index++) {
			exit[index] = fastReader.nextInt();
			exitIndex[exit[index]] = index;
		}
		int carsFined = findCarsFined(entry, exit, exitIndex);
		System.out.println(carsFined);

	}

	private static int findCarsFined(int[] entry, int[] exit, int[] exitIndex) {
		int maxCars = 0;
		int length = entry.length;
		int max = -1;
		int[] pos = new int[length + 1];
		for (int index = 0; index < length; index++) {
			pos[index + 1] = exitIndex[entry[index]];
		}
		for (int index = 1; index <= length; index++) {
			int val = pos[index];
			if (val > max) {
				max = val;
			} else {
				maxCars++;
			}
		}
		return maxCars;
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
