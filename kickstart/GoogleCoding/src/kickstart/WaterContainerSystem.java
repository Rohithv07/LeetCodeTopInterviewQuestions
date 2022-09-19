/**
 * 
 */
package kickstart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class WaterContainerSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			List<List<Integer>> graph = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
			}
			int k = 1;
			while (k < n) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				graph.get(u).add(v);
				graph.get(v).add(u);
				k++;
			}
//			for (int i = 0; i < n - 1; i++) {
//				connection[i][0] = sc.nextInt();
//				connection[i][1] = sc.nextInt();
//			}
			if (n == 1 && q == 1) {
				System.out.println("Case #" + t + ": " + 1);
			} else {
				int[] filler = new int[q];
				for (int i = 0; i < q; i++) {
					filler[i] = sc.nextInt();
				}
				System.out.println("Case #" + t + ": " + finalFillCount(n, q, graph, filler));
			}
		}
		sc.close();
	}

	private static int finalFillCount(int n, int q, List<List<Integer>> graph, int[] filler) {

		int [] parent = new int [n + 1];
		Arrays.fill(parent, -1);
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		int answer = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			q -= size;
			if (q >= 0) {
				answer += size;
				for (int i = 0; i < size; i++) {
					int top = queue.poll();
					List<Integer> children = graph.get(top);
					for (Integer child : children) {
						if (parent[top] != child) {
							queue.offer(child);
							parent[child] = top;
						}
					}
				}
			}
			else {
				break;
			}
		}
		return answer - 1;
	}


	private static List<List<Integer>> buildGraph(int n, int[][] connection) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] conn : connection) {
			int u = conn[0];
			int v = conn[1];
			graph.get(v).add(u);
			graph.get(u).add(v);
		}
		return graph;
	}
}
