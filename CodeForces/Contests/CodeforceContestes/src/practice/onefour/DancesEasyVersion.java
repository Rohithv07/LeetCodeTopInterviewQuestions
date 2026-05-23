/**
 * @author rohithvazhathody
 * @date 28 Apr 2026
 * Project: CodeforceContestes
 * File: DancesEasyVersion.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class DancesEasyVersion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int m = fastReader.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			a[0] = 1;
			for (int index = 1; index < n; index++) {
				a[index] = fastReader.nextInt();
			}
			for (int index = 0; index < n; index++) {
				b[index] = fastReader.nextInt();
			}
			int minOp = findMinOperation(a, b);
			System.out.println(minOp);
		}
	}

	private static int findMinOperation(int[] a, int[] b) {
		int p1 = 0;
		int p2 = 0;
		int operation = 0;
		Arrays.sort(a);
		Arrays.sort(b);
		int length = a.length;
		while (p1 < length && p2 < length) {
			int num1 = a[p1];
			int num2 = b[p2];
			if (num1 < num2) {
				p1++;
				p2++;
			} else if (num1 >= num2) {
				operation++;
				p2++;
			}
		}
		return operation;
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
 * 1 5 1 5 3 8 3 3
 * 
 * 1 1 5 5 3 3 8
 * 
 * 1 1 5 5 3 3 8
 * 
 * 
 * 
 * 1 4 3 3 2 2 1 1 1 1 1 1 3 3 3 3
 * 
 * 1 1 1 2 2 3 3 4 3 3 3 3
 * 
 * 
 * 1 1
 * 2 3
 * 
 * 
 * 
 */