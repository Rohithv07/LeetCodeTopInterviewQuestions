/**
 * @author rohithvazhathody
 * @date 25 Jul 2026
 * Project: CodeforceContestes
 * File: BetweenPAndQ.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class BetweenPAndQ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int n = fastReader.nextInt();
		int[] p = new int[n];
		int[] q = new int[n];
		for (int index = 0; index < n; index++) {
			p[index] = fastReader.nextInt();
		}
		for (int index = 0; index < n; index++) {
			q[index] = fastReader.nextInt();
		}
		long numberOfSequence = findSequence(p, q);
		out.println(numberOfSequence);
		out.flush();
		out.close();
	}

	private static long findSequence(int[] p, int[] q) {
		int n = p.length;
		long[] fact = new long[n + 1];
		fact[0] = 1;
		fact[1] = 1;
		for (int index = 2; index <= n; index++) {
			fact[index] = fact[index - 1] * index;
		}
		long rankP = findRank(p, fact);
		long rankQ = findRank(q, fact);
		long total = rankQ - rankP - 1;
		if (total <= 0) {
			return 0;
		}
		return total;
	}

	private static long findRank(int[] p, long[] fact) {
		int n = p.length;
		long rank = 0;
		boolean[] numberUsed = new boolean[n + 1];
		for (int index = 0; index < n; index++) {
			int smallerUnused = 0;
			for (int j = 1; j < p[index]; j++) {
				if (!numberUsed[j]) {
					smallerUnused++;
				}
			}
			rank += smallerUnused * fact[n - index - 1];
			numberUsed[p[index]] = true;
		}
		return rank;
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
