/**
 * @author rohithvazhathody
 * @date 18 Jul 2026
 * Project: CodeforceContestes
 * File: InversionOfSubsequence.java
 */

package contests.round1111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class InversionOfSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			for (int index = 0; index < n; index++) {
				a[index] = fastReader.nextInt();
			}
			for (int index = 0; index < n; index++) {
				b[index] = fastReader.nextInt();
			}
			long minOperation = findMinOperation(a, b);
			out.println(minOperation);
		}
		out.flush();
		out.close();
	}

	private static long findMinOperation(int[] a, int[] b) {
		int length = a.length;
		if (length == 1) {
			if (a[0] == b[0]) {
				return 0;
			}
			if (a[0] == 1) {
				return 1;
			}
			if (a[0] == 0) {
				return -1;
			}
		}
		// check if everything already equal
		boolean alreadyEqual = true;
		for (int index = 0; index < length; index++) {
			if (a[index] != b[index]) {
				alreadyEqual = false;
				break;
			}
		}
		if (alreadyEqual) {
			return 0;
		}
		int totalOnes = 0;
		int totalOnesInMismatch = 0;
		int totalZeroOutsideMismatch = 0;
		for (int index = 0; index < length; index++) {
			int currentA = a[index];
			int currentB = b[index];
			if (currentA == 1) {
				totalOnes++;
			}
			if (currentA != currentB) {
				if (currentA == 1) {
					totalOnesInMismatch++;
				}
			} else {
				if (currentA == 0) {
					totalZeroOutsideMismatch++;
				}
			}
		}
		if (totalOnes == 0) {
			return -1; // we won't be able to get an odd sum and make it equal to b
		}
		if (totalOnesInMismatch % 2 == 1) {
			return 1; // since odd subsequence, we can make it directly in 1
		}
		if (totalOnesInMismatch >= 1) {
			return 2;
		}
		if (totalZeroOutsideMismatch > 0) {
			return 2;
		}
		return -1;
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
 * 4 1 0 1 0 0 1 0 1
 * 
 * 
 * 1 1 2 2 0 1 1 2
 * 
 * 
 * 1 0 1 0 1 1 1 1 1 1
 * 
 * 
 * 1 1 2 2 3 1 2 3 4 5
 * 
 */
