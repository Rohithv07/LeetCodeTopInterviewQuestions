/**
- @author rohithvazhathody
- @date 21 Nov 2026
- Project: CodeforceContestes
- File: CutThemAll.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
- 
 */
public class CutThemAll {

	private static int cuts;

	/**
- @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = 1;
		while (test-- > 0) {
			int n = fastReader.nextInt();
			if (n % 2 == 1) {
				out.println(-1);
				continue;
			}
			List<List<Integer>> graph = new ArrayList<>();
			for (int index = 0; index <= n; index++) {
				graph.add(new ArrayList<>());
			}
			for (int index = 0; index + 1 < n; index++) {
				int u = fastReader.nextInt();
				int v = fastReader.nextInt();
				graph.get(u).add(v);
				graph.get(v).add(u);
			}

			cuts = 0;
			dfs(1, 0, graph);
			out.println(cuts);
		}
		out.flush();
		out.close();
	}

	private static int dfs(int node, int parent, List<List<Integer>> graph) {
		int subtreeSize = 1;
		for (int neighbor : graph.get(node)) {
			if (neighbor != parent) {
				subtreeSize += dfs(neighbor, node, graph);
			}
		}
		if (node != 1 && subtreeSize % 2 == 0) {
			cuts++;
		}
		return subtreeSize;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			try {
				while (st == null || !st.hasMoreTokens()) {
					st = new StringTokenizer(br.readLine());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

}