/**
 * @author rohithvazhathody
 * @date 25 Jul 2026
 * Project: CodeforceContestes
 * File: CorridorWatch.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class CorridorWatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int n = fastReader.nextInt();
		int d = fastReader.nextInt();
		String s = fastReader.next();
		int unguarded = findNumberOfUnGuarded(d, s);
		out.println(unguarded);
		out.flush();
		out.close();
	}

	private static int findNumberOfUnGuarded(int d, String s) {
		int[] diff = new int[s.length() + 2];
		int unguarded = 0;
		for (int index = 0; index < s.length(); index++) {
			if (s.charAt(index) == 'G') {
				int leftMost = Math.max(0, index - d);
				int rightMost = Math.min(s.length() - 1, index + d);
				diff[leftMost]++;
				diff[rightMost + 1]--;
			}
		}
		int prefixSum = 0;
		for (int index = 0; index < s.length(); index++) {
			prefixSum += diff[index];
			if (prefixSum == 0) {
				unguarded++;
			}
		}
		
		return unguarded;
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
