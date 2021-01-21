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

class MaxPathSumTree {

	static int result = Integer.MIN_VALUE;
	public static int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		dfs(root);
		return result;
	}

	public static int dfs(TreeNode node) {
		if (node == null)
			return 0;
		int left = Math.max(dfs(node.left), 0);
		int right = Math.max(dfs(node.right), 0);
		result = Math.max(result, left + right + node.val);
		return Math.max(left, right) + node.val;
	}

	public static void main(String [] args) {
		TreeNode root = new TreeNode(-10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(maxPathSum(root));
	}
}