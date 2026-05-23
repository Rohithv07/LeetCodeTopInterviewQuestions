/**
 * @author rohithvazhathody
 * @date 1 May 2026
 * Project: CodeforceContestes
 * File: HossamAndFriends.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class HossamAndFriends {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int m = fastReader.nextInt();
			int[][] pairs = new int[m][2];
			for (int index = 0; index < m; index++) {
				pairs[index][0] = fastReader.nextInt();
				pairs[index][1] = fastReader.nextInt();
			}
			long pairCount = findTotalPairs(n, pairs);
			System.out.println(pairCount);
		}
	}

	private static long findTotalPairs(int length, int[][] pairs) {
		int [] maxBadLeft = new int [length + 1];
		for (int [] pair : pairs) {
			int u = pair[0];
			int v = pair[1];
			if (u > v) {
				int temp = u;
				u = v;
				v = temp;
			}
			maxBadLeft[v] = Math.max(maxBadLeft[v], u);
		}
		long total = 0;
		int left = 1;
		int right = 1;
		for (right = 1; right <= length; right++) {
			left = Math.max(left, maxBadLeft[right] + 1);
			total += (right - left + 1);
		}
		return total;
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
