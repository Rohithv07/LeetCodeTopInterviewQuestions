/**
 * @author rohithvazhathody
 * @date 25 Apr 2026
 * Project: CodeforceContestes
 * File: JumpingThroughSegments.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class JumpingThroughSegments {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			long[][] boundaries = new long[n][2];
			for (int index = 0; index < n; index++) {
				boundaries[index][0] = fastReader.nextLong();
				boundaries[index][1] = fastReader.nextLong();
			}
			int minValue = findMinValueToComplete(boundaries);
			System.out.println(minValue);
		}
	}

	private static int findMinValueToComplete(long[][] boundaries) {
		int low = 0;
		int high = (int) (1e9);
		int answer = -1;
		while (low <= high) {
			int middle = low + (high - low) / 2;
			if (isPossibleToComplete(boundaries, middle)) {
				answer = middle;
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return answer;
	}

	private static boolean isPossibleToComplete(long[][] boundaries, int key) {
		long jump = key;
		long leftJump = 0;
		long rightJump = 0;
		for (long[] boundary : boundaries) {
			long start = boundary[0];
			long end = boundary[1];
			leftJump -= jump;
			rightJump += jump;
			leftJump = Math.max(leftJump, start);
			rightJump = Math.min(rightJump, end);
			if (leftJump > rightJump) {
				return false;
			}
		}
		return true;
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
