/**
 * @author rohithvazhathody
 * @date 22 Apr 2026
 * Project: CodeforceContestes
 * File: MahmoudIhabAndBipartite.java
 */

package practice.onethree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */
public class MahmoudIhabAndBipartite {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int n = fastReader.nextInt();
		List<List<Integer>> graph = new ArrayList<>();
		for (int index = 0; index < n; index++) {
			graph.add(new ArrayList<>());
		}
		int[][] edges = new int[n - 1][2];
		for (int index = 0; index < n - 1; index++) {
			edges[index][0] = fastReader.nextInt() - 1;
			edges[index][1] = fastReader.nextInt() - 1;
		}
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		UnionFind unionFind = new UnionFind(n);
		for (int u = 0; u < n; u++) {
			List<Integer> neighbour = graph.get(u);
			if (neighbour.size() <= 1) {
				continue;
			}
			int firstNeigh = neighbour.get(0);
			for (int next = 1; next < neighbour.size(); next++) {
				int secondNeigh = neighbour.get(next);
				unionFind.union(firstNeigh, secondNeigh);
			}
		}
		long red = unionFind.getSize(0);
		long black = n - red;
		System.out.println((1L * red * black) - (n - 1));
	}

	static class UnionFind {
		int[] parent;
		int[] size;

		public UnionFind(int n) {
			if (n <= 0) {
				throw new IllegalArgumentException("N cannot be less or equalt to 0");
			}
			parent = new int[n];
			size = new int[n];
			for (int index = 0; index < n; index++) {
				parent[index] = index;
				size[index] = 1;
			}
		}

		public int find(int node) {
			if (node != parent[node]) {
				return parent[node] = find(parent[node]);
			}
			return node;
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

		public int getSize(int node) {
			return size[find(node)];
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
