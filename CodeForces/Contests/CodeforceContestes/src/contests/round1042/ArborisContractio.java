package contests.round1042;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author rohithvazhathody 10-Aug-2025
 */
public class ArborisContractio {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			List<List<Integer>> graph = new ArrayList<>();
			for (int i = 0; i <= n; i++)
				graph.add(new ArrayList<>());

			for (int i = 0; i < n - 1; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				graph.get(u).add(v);
				graph.get(v).add(u);
			}

			System.out.println(minOperations(graph, n));
		}
		sc.close();
	}

	private static int minOperations(List<List<Integer>> graph, int n) {
		if (n == 2) {
			return 0;
		}
		boolean[] trackLeaf = findLeaf(graph, n);
		int totalLeaf = 0;
		for (int index = 1; index <= n; index++) {
			if (trackLeaf[index]) {
				totalLeaf++;
			}
		}
		int remaining = 0;
		for (int v = 1; v <= n; v++) {
			int count = trackLeaf[v] ? 1 : 0;
			List<Integer> children = graph.get(v);
			for (Integer child : children) {
				if (trackLeaf[child]) {
					count++;
				}
			}
			if (count > remaining) {
				remaining = count;
			}
		}
		return totalLeaf - remaining;
	}

	private static boolean[] findLeaf(List<List<Integer>> graph, int n) {
		boolean[] leaf = new boolean[n + 1];
		for (int index = 1; index <= n; index++) {
			if (graph.get(index).size() == 1) {
				leaf[index] = true;
			}
		}
		return leaf;
	}
}
