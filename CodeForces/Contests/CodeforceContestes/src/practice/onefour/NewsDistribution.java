/**
 * @author rohithvazhathody
 * @date 30 May 2026
 * Project: CodeforceContestes
 * File: NewsDistribution.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */
public class NewsDistribution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int n = fastReader.nextInt();
		int m = fastReader.nextInt();
		List<List<Integer>> graph = new ArrayList<>();
		buildGraph(graph, n, m, fastReader);
		int[] totalSizes = findTotalSize(graph, n);
		for (int size : totalSizes) {
			System.out.print(size + " ");
		}
	}

	private static int[] findTotalSize(List<List<Integer>> graph, int n) {
		UnionFind unionFind = new UnionFind(n);
		int[] result = new int[n];
		Arrays.fill(result, -1);
		for (int index = 1; index <= n; index++) {
			List<Integer> children = graph.get(index);
			if (children == null || children.size() == 0) {
				result[index - 1] = 1;
			} else {
				for (Integer child : children) {
					unionFind.union(index, child);
				}
			}
		}
		for (int index = 1; index <= n; index++) {
			if (result[index - 1] != -1) {
				continue;
			}
			int parent = unionFind.find(index);
			int size = unionFind.size[parent];
			result[index - 1] = size;
		}
		return result;
	}

	private static void buildGraph(List<List<Integer>> graph, int n, int m, FastReader fastReader) {
		for (int index = 0; index <= n; index++) {
			graph.add(new ArrayList<>());
		}
		for (int index = 0; index < m; index++) {
			int size = fastReader.nextInt();
			if (size == 0) {
				continue;
			}
			int node1 = fastReader.nextInt();
			size--;
			while (size-- > 0) {
				int node2 = fastReader.nextInt();
				graph.get(node1).add(node2);
				graph.get(node2).add(node1);
			}
		}
	}

	static class UnionFind {
		int[] parent;
		int[] size;

		public UnionFind(int n) {
			parent = new int[n + 1];
			size = new int[n + 1];
			for (int index = 1; index <= n; index++) {
				parent[index] = index;
				size[index] = 1;
			}
		}

		public int find(int node) {
			if (node != parent[node]) {
				return parent[node] = find(parent[node]);
			}
			return parent[node];
		}

		public void union(int node1, int node2) {
			int parent1 = find(node1);
			int parent2 = find(node2);
			if (parent1 == parent2) {
				return;
			}
			if (size[parent1] < size[parent2]) {
				parent[parent1] = parent2;
				size[parent2] += size[parent1];
			} else {
				parent[parent2] = parent1;
				size[parent1] += size[parent2];
			}
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
