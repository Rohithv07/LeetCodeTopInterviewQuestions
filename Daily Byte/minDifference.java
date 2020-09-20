Given a binary search tree, return the minimum difference between any two nodes in the tree.

Ex: Given the following tree...
        2
       / \
      3   1
return 1.
Ex: Given the following tree...
        29
       /  \
     17   50
    /     / \
   1    42  59
return 8.
Ex: Given the following tree...
        2
         \
         100
return 98.

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){};
	TreeNode(int val) {
		this.val = val;
	}
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Solution {
	int min = Integer.MAX_VALUE;
	public int minDifference(TreeNode root) {
		int previousVisited = -1;
		dfs(root, previousVisited);
		return min;
	}
	public void dfs(TreeNode node, int prev) {
		if (root == null)
			return;
		dfs(node.left);
		if (prev != -1)
			min = Math.min(min, Math.abs(node.val - prev));
		prev = node.val;
		dfs(node.right);
	}
}
