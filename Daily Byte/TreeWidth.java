/*
Given a reference to a binary tree, return the width of the tree. The width of the tree is defined as the length of the longest path between any two nodes in the tree.
Note: The length of the longest path is measured by the number of edges between the two nodes.

Ex: Given the following binary tree...

         1
       /   \
     3      9
    / \
   8   7, return 3 (there are three edges between 8->3->1->9 and 7->3->1->9).
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

public class TreeWidth {

	public static int findWidth(TreeNode root) {
		if (root == null)
			return 0;
		// find the leftHeight and rightHeight
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		// get the width of left and right subtrews
		int leftWidth = findWidth(root.left);
		int rightWidth = findWidth(root.right);
		// return the max(heights + 1,  max(widths))
		return Math.max(leftHeight + rightHeight + 1, Math.max(leftWidth, rightWidth)) - 1;
	}

	public static int height(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}

	public static void main(String [] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(9);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(7);
		System.out.println(findWidth(root));
	}
}