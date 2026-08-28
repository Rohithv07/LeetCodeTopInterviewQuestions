/**
 * @author rohithvazhathody
 * @date 5 Aug 2026
 * Project: CodeforceContestes
 * File: Marenol.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class Marenol {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			String a = fastReader.next();
			String b = fastReader.next();
			String possible = findIfPossible(a, b);
			out.println(possible);
		}
		out.flush();
		out.close();
	}

	private static String findIfPossible(String a, String b) {
		if (a.equals(b)) {
			return "YES";
		}
		int length = a.length();
		if (length < 3) {
			return a.equals(b) ? "YES" : "NO";
		}
		int countZeroA = 0;
		int countZeroB = 0;
		int zerosAtOddPositionA = 0;
		int zerosAtEvenPositionA = 0;
		int zerosAtOddPositionB = 0;
		int zerosAtEvenPositionB = 0;
		for (int index = 0; index < length; index++) {
			if (a.charAt(index) == '0') {
				countZeroA++;
			}
			if (b.charAt(index) == '0') {
				countZeroB++;
			}
			if (index % 2 == 0) {
				if (a.charAt(index) == '0') {
					zerosAtEvenPositionA++;
				}
				if (b.charAt(index) == '0') {
					zerosAtEvenPositionB++;
				}
			} else {
				if (a.charAt(index) == '0') {
					zerosAtOddPositionA++;
				}
				if (b.charAt(index) == '0') {
					zerosAtOddPositionB++;
				}
			}
		}
		if (countZeroA != countZeroB) {
			return "NO";
		}
		return ((zerosAtEvenPositionA == zerosAtEvenPositionB) && (zerosAtOddPositionA == zerosAtOddPositionB)) ? "YES"
				: "NO";
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
