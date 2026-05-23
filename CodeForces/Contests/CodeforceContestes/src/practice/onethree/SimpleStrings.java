/**
 * @author rohithvazhathody
 * @date 23 Apr 2026
 * Project: CodeforceContestes
 * File: SimpleStrings.java
 */

package practice.onethree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class SimpleStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		String s = fastReader.next();
		String adjacent = findAdjacent(s);
		System.out.println(adjacent);
	}

	private static String findAdjacent(String s) {
		char[] result = new char[s.length()];
		int length = s.length();
		result[0] = s.charAt(0);
		for (int index = 1; index < length; index++) {
			if (s.charAt(index) != result[index - 1]) {
				result[index] = s.charAt(index);
				continue;
			}
			for (char next = 'a'; next <= 'z'; next++) {
				if (s.charAt(index - 1) != next) {
					if (index < length - 1 && next != s.charAt(index + 1)) {
						result[index] = next;
						break;
					} else if (index == length - 1) {
						result[index] = next;
						break;
					}
				}
			}
		}
		return new String(result);
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
