/**
 * @author rohithvazhathody
 * @date 18 Apr 2026
 * Project: CodeforceContestes
 * File: MoveAndTurn.java
 */

package practice.onethree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class MoveAndTurn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int n = fastReader.nextInt();
		int k = n / 2;
		if (n % 2 == 0) {
			int val =  (k + 1) * (k + 1);
			System.out.println(val);
		}
		else {
			int val = 2 * (k + 1) * (k + 2);
			System.out.println(val);
		}

	}

	static class FastReader {
		BufferedReader bufferedReader;
		StringTokenizer tokenizer;

		public FastReader() {
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (tokenizer == null || !tokenizer.hasMoreElements()) {
				try {
					tokenizer = new StringTokenizer(bufferedReader.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return tokenizer.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

}
