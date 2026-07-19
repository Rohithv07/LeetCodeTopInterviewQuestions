/**
 * @author rohithvazhathody
 * @date 19 Jul 2026
 * Project: CodeforceContestes
 * File: OMSKProgrammers.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class OMSKProgrammers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			long a = fastReader.nextLong();
			long b = fastReader.nextLong();
			long x = fastReader.nextLong();
			long minOperation = findMinOperation(a, b, x);
			out.println(minOperation);
		}
		out.flush();
		out.close();
	}

	private static long findMinOperation(long a, long b, long x) {
		if (a == b) {
			return 0;
		}
		if (a + 1 == b || b + 1 == a) {
			return 1;
		}
		long minOperation = Math.abs(a - b);
		long currentOperation = 0;
		while (a != b) {
			if (a < b) {
				long temp = a;
				a = b;
				b = temp;
			}
			minOperation = Math.min(minOperation, Math.abs(a - b) + currentOperation);
			currentOperation++;
			a /= x;
		}
		minOperation = Math.min(currentOperation, minOperation);
		return minOperation;
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
