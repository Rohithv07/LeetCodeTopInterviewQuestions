/*

A boring tree is a tree whose nodes only contain a single value. Given a reference to the root of a binary tree, root, return whether or not it is a boring tree.
Note: It is guaranteed that a single value exists within the tree.

Ex: Given the following root…

       7
      / \
     7   7, return true.
Ex: Given the following root…

       1
      / \
     2   3, return false.

*/


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

public class BoringTree {

	public static boolean isBoringTree(TreeNode root) {
		if (root == null)
			return true;
		int checkValue = root.val;
		return dfsHelper(root, checkValue);
	}

	public static boolean dfsHelper(TreeNode node, int checkValue) {
		if (node == null)
			return true;
		if (node.val != checkValue)
			return false;
		return dfsHelper(node.left, checkValue) && dfsHelper(node.right, checkValue);
	}

	public static void main(String [] args) {
		TreeNode root1 = new TreeNode(7);
		root1.left = new TreeNode(7);
		root1.right = new TreeNode(7);
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		System.out.println(isBoringTree(root1));
		System.out.println(isBoringTree(root2));
	}
}























