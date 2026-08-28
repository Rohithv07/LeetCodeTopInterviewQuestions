/**
 * @author rohithvazhathody
 * @date 4 Aug 2026
 * Project: CodeforceContestes
 * File: RipTide.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * 
 */
public class RipTide {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int a = fastReader.nextInt();
			int b = fastReader.nextInt();
			int c = fastReader.nextInt();
			int result = Math.min(Math.abs(a - b), Math.min(Math.abs(b - c), Math.abs(c - a)));
			out.println(result);
		}
		out.close();
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
