/**
 * @author rohithvazhathody
 * @date 1 May 2026
 * Project: CodeforceContestes
 * File: CopilCopacDrawsTrees.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */
public class CopilCopacDrawsTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int nodes = fastReader.nextInt();
			List<List<Edge>> graph = new ArrayList<>();
			for (int index = 0; index <= nodes; index++) {
				graph.add(new ArrayList<>());
			}
			for (int index = 0; index < nodes - 1; index++) {
				int u = fastReader.nextInt();
				int v = fastReader.nextInt();
				graph.get(u).add(new Edge(v, index + 1));
				graph.get(v).add(new Edge(u, index + 1));
			}
			int reading = findMinReading(graph);
			System.out.println(reading);
		}
	}

	private static int findMinReading(List<List<Edge>> graph) {
		int[] maxReadings = new int[] { 1 };
		dfs(graph, 1, -1, 0, 1, maxReadings);
		return maxReadings[0];
	}

	private static void dfs(List<List<Edge>> graph, int currentVertex, int parent, int previousIndex,
			int currentReading, int[] maxReading) {
		maxReading[0] = Math.max(maxReading[0], currentReading);
		List<Edge> neighbour = graph.get(currentVertex);
		for (Edge edge : neighbour) {
			if (edge.to != parent) {
				int nextReading = currentReading;
				if (edge.index < previousIndex) {
					nextReading++;
				}
				dfs(graph, edge.to, currentVertex, edge.index, nextReading, maxReading);
			}
		}
	}

	static class Edge {
		int to;
		int index;

		public Edge(int to, int index) {
			this.to = to;
			this.index = index;
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
