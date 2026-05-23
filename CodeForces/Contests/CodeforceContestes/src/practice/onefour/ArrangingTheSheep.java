/**
 * @author rohithvazhathody
 * @date 4 May 2026
 * Project: CodeforceContestes
 * File: ArrangingTheSheep.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */
public class ArrangingTheSheep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			String s = fastReader.next();
			long minimumMoves = findMinimumMoves(s);
			System.out.println(minimumMoves);
		}
	}

	private static long findMinimumMoves(String s) {
		long total = 0;
		int prefixStar = 0;
		int totalStar = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '*') {
				totalStar++;
			}
		}
		for (char ch : s.toCharArray()) {
			if (ch == '*') {
				prefixStar++;
			}
			else {
				int suffixStar = totalStar - prefixStar;
				total += Math.min(prefixStar, suffixStar);
			}
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



/*
 * 
 * 
 * [0,0,1,0,0,0,3,0,1,0]
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
