/**
 * @author rohithvazhathody
 * @date 7 Jun 2026
 * Project: CodeforceContestes
 * File: VesselsHeightsAndTwoVersions.java
 */

package contests.round1102;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class VesselsHeightsAndTwoVersions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			long[] height = new long[n];
			for (int index = 0; index < n; index++) {
				height[index] = fastReader.nextLong();
			}
			long[] volumes = findVolumes(height);
			for (long vol : volumes) {
				System.out.print(vol + " ");
			}
			System.out.println();
		}
	}

	private static long[] findVolumes(long[] height) {
		int length = height.length;
		long[] result = new long[length];
		long[] flat = Arrays.copyOf(height, length);
		long[] prefixMax = new long[length];
		long[] suffixMax = new long[length];
		for (int index = 0; index < length; index++) {
			for (int j = 0; j < length; j++) {
				flat[j] = height[(index + j) % length];
			}
			prefixMax[0] = flat[0];
			suffixMax[length - 1] = flat[length - 1];
			for (int j = 1; j < length; j++) {
				prefixMax[j] = Math.max(prefixMax[j - 1], flat[j]);
			}
			for (int j = length - 2; j >= 0; j--) {
				suffixMax[j] = Math.max(suffixMax[j + 1], flat[j]);
			}
			long totalWaterNeeded = 0;
			for (int j = 0; j < length - 1; j++) {
				totalWaterNeeded += Math.min(prefixMax[j], suffixMax[j + 1]);
			}
			result[index] = totalWaterNeeded;
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
