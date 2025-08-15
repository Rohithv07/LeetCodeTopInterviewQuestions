package contests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author rohithvazhathody 15-Aug-2025
 */
public class ArborisContractio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			List<List<Integer>> graph = new ArrayList<>();
			for (int index = 0; index < n; index++) {
				graph.add(new ArrayList<>());
			}
			for (int index = 0; index < n - 1; index++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				u--;
				v--;
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			System.out.println(findMinOperation(graph, n));
		}
		sc.close();
	}

	private static int findMinOperation(List<List<Integer>> graph, int n) {
		int totalLeaf = 0;
		for (int index = 0; index < n; index++) {
			if (graph.get(index).size() == 1) {
				totalLeaf++;
			}
		}
		int totalOperation = Integer.MAX_VALUE;
		for (int index = 0; index < n; index++) {
			// if already leaf, minus 1
			int currentOperation = totalLeaf;
			if (graph.get(index).size() == 1) {
				currentOperation--;
			}
			List<Integer> children = graph.get(index);
			for (Integer child : children) {
				if (graph.get(child).size() == 1) {
					currentOperation--;
				}
			}
			totalOperation = Math.min(totalOperation, currentOperation);
		}
		return totalOperation;
	}

}
