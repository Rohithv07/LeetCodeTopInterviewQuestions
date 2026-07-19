/**
 * @author rohithvazhathody
 * @date 4 Jul 2026
 * Project: CodeforceContestes
 * File: DivideAndConquer.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class DivideAndConquer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int x = fastReader.nextInt();
			int y = fastReader.nextInt();
			if (x % y == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
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
