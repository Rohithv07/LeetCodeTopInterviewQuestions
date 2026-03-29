/**
 * @author rohithvazhathody
 * @date 5 Mar 2026
 * Project: CodeforceContestes
 * File: WhiteBlackBalancedSubtree.java
 */

package practice.onethree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class WhiteBlackBalancedSubtree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n - 1];
			for (int index = 0; index < n - 1; index++) {
				nums[index] = sc.nextInt();
			}
			String s = sc.next();
			int countSubtree = findSubtreeCount(s, nums, n);
			System.out.println(countSubtree);
		}
		sc.close();
	}

	private static int findSubtreeCount(String s, int[] nums, int n) {
		List<List<Integer>> graph = buildGraph(nums, n);
//		System.out.println(graph);
		int[] ans = new int[1];
		dfs(1, graph, s, ans);
		return ans[0];
	}

	private static int dfs(int node, List<List<Integer>> graph, String s, int[] ans) {
		if (graph.get(node).size() == 0) {
			return s.charAt(node - 1) == 'W' ? 1 : -1;
		}
		int count = 0;
		for (Integer child : graph.get(node)) {
			count += dfs(child, graph, s, ans);
		}
		count += s.charAt(node - 1) == 'W' ? 1 : -1;
		if (count == 0) {
			ans[0]++;
		}
		return count;
	}

	private static List<List<Integer>> buildGraph(int[] nums, int n) {
		// TODO Auto-generated method stub
		List<List<Integer>> graph = new ArrayList<>();
		for (int index = 0; index <= n; index++) {
			graph.add(new ArrayList<>());
		}
		for (int index = 0; index < n - 1; index++) {
			int val = nums[index];
			graph.get(val).add(index + 2);
		}
		return graph;
	}

}

/*
 * 
 * 
 * root tree : 1 to n with 1 root B and W color count(B) = count(W) -> count
 * subtree
 * 
 * 1 -1 1 -1 1 -1
 * 
 */