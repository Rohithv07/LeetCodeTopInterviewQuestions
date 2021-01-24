/*

You’re a thief trying to rob a binary tree. As a thief, you are trying to steal as much money as possible. The amount of money you steal is equivalent to the sum of all the node’s values that you decide to rob. If two adjacent nodes are robbed, the authorities are automatically alerted. Return the maximum loot that you can steal without alerting the authorities.

Ex: Given the following binary tree...

        2
      /   \
     5     7, return 12 (5 + 7 = 12).
Ex: Given the following binary tree...

        4
      /   \
     3     2
      \     \
       9     7, return 20 (4 + 9 + 7 = 20).

*/


import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode(int val) {
		this.val = val;
	}
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class MaxLoot {

	public static int robATree(TreeNode root) {
		if (root == null)
			return 0;
		int [] maxLoot = dfsLoot(root);
		return Math.max(maxLoot[0], maxLoot[1]);
	}

	public static int [] dfsLoot(TreeNode node) {
		if (node == null)
			return new int [2];
		int [] maxLoot = new int [2];
		int [] left = dfsLoot(node.left);
		int [] right = dfsLoot(node.right);
		maxLoot[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		maxLoot[1] = node.val + left[0] + right [0];
		return maxLoot;
	}

	public static void main(String [] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.right = new TreeNode(9);
		root.right.right = new TreeNode(7);
		System.out.println(robATree(root));
	}
}