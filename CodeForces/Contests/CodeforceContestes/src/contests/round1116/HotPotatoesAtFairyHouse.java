/**
 * @author rohithvazhathody
 * @date 9 Aug 2026
 * Project: CodeforceContestes
 * File: HotPotatoesAtFairyHouse.java
 */

package contests.round1116;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 
 */
public class HotPotatoesAtFairyHouse {

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
			long[] scores = findScores(k, s);
			out.println(scores[0] + " " + scores[1]);
		}
		out.flush();
		out.close();
	}

	private static long[] findScores(int k, String s) {
		int length = s.length();
		Set<Integer> alreadyHolding = new HashSet<>();
		for (int index = 0; index < s.length(); index++) {
			char ch = s.charAt(index);
			if (ch == '1')
				alreadyHolding.add(index);
		}
		// try to move it only at the very last round as that decides who will die
		Set<Integer> afterFinalMove = new HashSet<>();
		for (int index = 0; index < s.length(); index++) {
			if (alreadyHolding.contains(index)) {
				int veryNext = (index + 1) % length;
				if (alreadyHolding.contains(veryNext)) {
					afterFinalMove.add(index);
				} else {
					afterFinalMove.add(veryNext);
				}
			}
		}
		long red = 0;
		long blue = 0;
		for (int index = 0; index < s.length(); index++) {
			if (afterFinalMove.contains(index)) {
				if (index % 2 == 0) {
					blue++;
				} else {
					red++;
				}
			}
		}
		return new long[] { red, blue };
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
