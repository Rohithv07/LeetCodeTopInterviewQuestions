/**
 * @author rohithvazhathody
 * @date 18 Apr 2026
 * Project: CodeforceContestes
 * File: Shuffle.java
 */

package practice.onethree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class Shuffle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int x = fastReader.nextInt();
			int m = fastReader.nextInt();
			int[][] desc = new int[m][2];
			for (int index = 0; index < m; index++) {
				desc[index][0] = fastReader.nextInt();
				desc[index][1] = fastReader.nextInt();
			}
			int indicesCount = findIndicesCount(desc, n, m, x);
			System.out.println(indicesCount);
		}
	}

	private static int findIndicesCount(int[][] desc, int n, int m, int x) {
		int p1 = x;
		int p2 = x;
		for (int[] d : desc) {
			int l = d[0];
			int r = d[1];
			if (r >= p1 && l <= p2) {
				p1 = Math.min(p1, l);
				p2 = Math.max(p2, r);
			}
		}
		return p2 - p1 + 1;
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
 * 0 0 0 1 0 0
 * 
 * 0 0 0 1 0 0
 * 
 * 0 0 0 1 0 0
 * 
 * 0 0 0 1 0 0
 * 
 * 1 6 2 3 5 5
 * 
 * 
 * 
 * 
 * 
 * 
 */
