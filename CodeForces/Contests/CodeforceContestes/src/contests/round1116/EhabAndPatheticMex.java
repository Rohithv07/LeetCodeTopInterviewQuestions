/**
 * @author rohithvazhathody
 * @date 19 Aug 2026
 * Project: CodeforceContestes
 * File: EhabAndPatheticMex.java
 */

package contests.round1116;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */
public class EhabAndPatheticMex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int n = fastReader.nextInt();
		List<List<Integer>> graph = new ArrayList<>();
		for (int index = 1; index <= n; index++) {
			graph.add(new ArrayList<>());
		}
		for (int index = 0; index < n; index++) {
			int u = fastReader.nextInt();
			int v = fastReader.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
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
