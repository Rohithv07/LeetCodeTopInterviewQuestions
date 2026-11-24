/**
 * @author rohithvazhathody
 * @date 11 Nov 2026
 * Project: CodeforceContestes
 * File: DivisionAndUnion.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class DivisionAndUnion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int[][] segments = new int[n][3];
			for (int index = 0; index < n; index++) {
				segments[index][0] = fastReader.nextInt();
				segments[index][1] = fastReader.nextInt();
				segments[index][2] = index;
			}
			int[] groups = findGroups(segments);
			if (groups == null || groups.length == 0) {
				out.println("-1");
			} else {
				for (int val : groups) {
					out.print(val + " ");
				}
				out.println();
			}
		}
		out.flush();
		out.close();
	}

	private static int[] findGroups(int[][] segments) {
		Arrays.sort(segments, (s1, s2) -> {
			return Integer.compare(s1[0], s2[0]);
		});
		// if overlapping return null immediately
		// else have it
		int[] result = new int[segments.length];
		int maxR = -1;
		int splitPoint = -1;
		for (int index = 0; index < segments.length - 1; index++) {
			maxR = Math.max(maxR, segments[index][1]);
			if (maxR < segments[index + 1][0]) {
				splitPoint = index;
				break;
			}
		}
		if (splitPoint == -1) {
			return null;
		}
		for (int index = 0; index < segments.length; index++) {
			if (index <= splitPoint) {
				result[segments[index][2]] = 1;
			} else {
				result[segments[index][2]] = 2;
			}
		}
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
				while (st == null || !st.hasMoreTokens()) {
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
