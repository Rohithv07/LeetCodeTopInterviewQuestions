/**
 * @author rohithvazhathody
 * @date 1 Aug 2026
 * Project: CodeforceContestes
 * File: YouDeleteIDelete.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * 
 */
public class YouDeleteIDelete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			String s = fastReader.next();
			StringBuilder sb = new StringBuilder();
			boolean firstZeroFound = false;
			boolean firstOneFound = false;
			for (char ch : s.toCharArray()) {
				if (ch == '0' && !firstZeroFound) {
					firstZeroFound = true;
				}
				else if (ch == '1' && !firstOneFound) {
					firstOneFound = true;
				}
				else {
					sb.append(ch);
				}
			}
			out.println(sb.toString());
		}
		out.flush();
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
