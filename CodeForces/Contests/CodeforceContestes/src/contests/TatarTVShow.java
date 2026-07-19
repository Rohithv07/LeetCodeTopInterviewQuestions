/**
 * @author rohithvazhathody
 * @date 19 Jul 2026
 * Project: CodeforceContestes
 * File: TatarTVShow.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class TatarTVShow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int k = fastReader.nextInt();
			String s = fastReader.next();
			String possible = findPossible(s, k);
			out.println(possible);
		}
		out.flush();
		out.close();
	}

	private static String findPossible(String s, int k) {
		int length = s.length();
		if (length == 1 && s.charAt(0) == '0') {
			return "YES";
		}
		if (length == 1 && s.charAt(0) == '1') {
			return "NO";
		}
		char [] sArray = s.toCharArray();
		for (int index = 0; index < length; index++) {
			char currentChar = sArray[index];
			if (currentChar == '0') {
				continue;
			}
			sArray[index] = '0';
			if (index + k < length) {
				sArray[index + k] = sArray[index + k] == '0' ? '1' : '0';
			}
			else {
				return "NO";
			}
		}
		for (char ch : sArray) {
			if (ch == '1') {
				return "NO";
			}
		}
		return "YES";
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
