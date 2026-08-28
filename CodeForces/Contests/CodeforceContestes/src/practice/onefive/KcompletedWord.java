/**
 * @author rohithvazhathody
 * @date 16 Aug 2026
 * Project: CodeforceContestes
 * File: KcompletedWord.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class KcompletedWord {

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
			int minOperation = findMinOperation(k, s);
			out.println(minOperation);
		}
		out.flush();
		out.close();
	}

	private static int findMinOperation(int k, String s) {
		int length = s.length();
		int blocks = length / k;
		int replacement = 0;
		for (int index = 0; index < k / 2; index++) {
			int[] freq = new int[26];
			int maxFreq = 0;
			for (int c = 0; c < blocks; c++) {
				char leftChar = s.charAt(c * k + index);
				char rightChar = s.charAt(c * k + (k - 1 - index));
				freq[leftChar - 'a']++;
				freq[rightChar - 'a']++;
			}
			for (int fre : freq) {
				maxFreq = Math.max(maxFreq, fre);
			}
			replacement += (2 * blocks) - maxFreq;
		}
		if (k % 2 != 0) {
			int index = k / 2;
			int[] freq = new int[26];
			int maxFreq = 0;
			for (int c = 0; c < blocks; c++) {
				char leftChar = s.charAt(c * k + index);
				freq[leftChar - 'a']++;
			}
			for (int fre : freq) {
				maxFreq = Math.max(maxFreq, fre);
			}
			replacement += (blocks) - maxFreq;
		}
		return replacement;
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
