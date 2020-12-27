/*Given the reference to the root of a binary tree and a value k, return the number of paths in the tree such that the sum of the nodes along the path equals k.
Note: The path does not need to start at the root of the tree, but must move downward.

Ex: Given the following binary tree and value k…

      3
     / \
    1   8
k = 11, return 1 (3 -> 8).
Ex: Given the following binary tree and value k…

      2
     / \
   -4   9
   /
  2
k = 2, return 3 (2, 2 -> -4, -4 -> 2).
*/

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) {
		this.val = val;
	}
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class TreePaths {

	public static int howManyPath(TreeNode root, int target) {
		if (root == null)
			return 0;
		int [] count = new int [1];
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		dfsHelper(root, 0, target, map, count);
		return count[0];
	}

	public static void dfsHelper(TreeNode node, int currentSum, int target, Map<Integer, Integer> map, int [] count) {
		if (node == null)
			return;
		currentSum += node.val;
		// if the map contains cureentSum-target as key, then we got a possible count
		if (map.containsKey(currentSum - target))
			count[0] += map.get(currentSum - target);
		// we add the currentSum and its occurance in the map
		map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
		dfsHelper(node.left, currentSum, target, map, count);
		dfsHelper(node.right, currentSum, target, map, count);
		// minus 1 from the currentSum key 
		map.put(currentSum, map.get(currentSum) - 1);
	}

	public static void main(String [] args) {
		TreeNode tree = new TreeNode(10);
		tree.left = new TreeNode(5);
		tree.right = new TreeNode(-3);
		tree.right.right = new TreeNode(11);
		tree.left.left = new TreeNode(3);
		tree.left.right = new TreeNode(2);
		tree.left.right.right = new TreeNode(1);
		tree.left.left.left = new TreeNode(3);
		tree.left.left.right = new TreeNode(-2);


		int target = 8;
		System.out.println(howManyPath(tree, target));
	}
}