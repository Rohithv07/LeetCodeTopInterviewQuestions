/*
Given the reference to a binary search tree and a value to insert, return a reference to the root of the tree after the value has been inserted in a position that adheres to the invariants of a binary search tree.
Note: It is guaranteed that each value in the tree, including the value to be inserted, is unique.

Ex: Given the following tree and value…

      2
     / \
    1   3
value = 4, return the following tree...
      2
     / \
    1   3
         \
          4
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

class NewValue {

	public static TreeNode insertValue(TreeNode root, int value) {
		if (root == null) {
			root = new TreeNode(value);
			return root;
		}

		if (root.val < value) {
			root.right = insertValue(root.right, value);
		}
		else {
			root.left = insertValue(root.left, value);
		}
		return root;
	}

	public static void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.println(root.val);
			inorder(root.right);
		}
	}

	public static void main(String [] args) {
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(30);
		root.right = new TreeNode(70);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(40);
		root.right.left = new TreeNode(60);
		int valueToInsert = 33;
		root = insertValue(root, valueToInsert);
		inorder(root);
	}
}