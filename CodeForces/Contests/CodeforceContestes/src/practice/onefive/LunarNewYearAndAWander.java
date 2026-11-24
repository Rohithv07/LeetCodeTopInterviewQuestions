/**
 * @author rohithvazhathody
 * @date 10 Nov 2026
 * Project: CodeforceContestes
 * File: LunarNewYearAndAWander.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 
 */
public class LunarNewYearAndAWander {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = 1;
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int m = fastReader.nextInt();
			List<List<Integer>> graph = new ArrayList<>();
			for (int index = 0; index <= n; index++) {
				graph.add(new ArrayList<>());
			}
			for (int index = 0; index < m; index++) {
				int u = fastReader.nextInt();
				int v = fastReader.nextInt();
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			List<Integer> wanderSeq = findWanderSeq(graph);
			for (int val : wanderSeq) {
				out.print(val + " ");
			}
			out.println();
		}
		out.flush();
		out.close();
	}

	private static List<Integer> findWanderSeq(List<List<Integer>> graph) {
		List<Integer> result = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		minHeap.offer(1);
		visited.add(1);
		while (!minHeap.isEmpty()) {
			int node = minHeap.poll();
			result.add(node);
			List<Integer> neighbours = graph.get(node);
			for (int neighbour : neighbours) {
				if (!visited.contains(neighbour)) {
					minHeap.offer(neighbour);
					visited.add(neighbour);
				}
			}
		}
		return result;
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
