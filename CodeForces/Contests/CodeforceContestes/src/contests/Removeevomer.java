/**
 * @author rohithvazhathody
 * @date 4 Jul 2026
 * Project: CodeforceContestes
 * File: Removeevomer.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class Removeevomer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			String s = fastReader.next();
			int minLength = findMinLength(s);
			out.println(minLength);
		}
		out.flush();
		out.close();
	}

	private static int findMinLength(String s) {
		char[] newS = s.toCharArray();
		int count0 = 0;
		int count1 = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '0') {
				count0++;
			} else {
				count1++;
			}
		}
		if (count0 == s.length() || count1 == s.length()) {
			return 1;
		}
		Arrays.sort(newS);
		String newString = new String(newS);
		//System.out.println(newString);
		if (sameLeftRight(s, newString) || sameRightLeft(s, newString)) {
			return 2;
		}
		return 1;
	}

	private static boolean sameRightLeft(String s, String newString) {
		int left = 0;
		int right = s.length() - 1;
		while (right >= 0 && left < s.length()) {
			if ((s.charAt(left) != newString.charAt(right))) {
				//System.out.println(s.charAt(right) + " " + newString.charAt(right));
				return false;
			}
			right--;
			left++;
		}
		return true;
	}

	private static boolean sameLeftRight(String s, String newString) {
		int left = 0;
		while (left < s.length()) {
			if ((s.charAt(left) != newString.charAt(left))) {
				return false;
			}
			left++;
		}

		return true;
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
