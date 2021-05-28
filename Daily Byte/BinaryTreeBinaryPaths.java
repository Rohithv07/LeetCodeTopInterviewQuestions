/*
You are given the root of a binary tree. Each node in the tree contains either a value of zero or a value of one. Each path in the tree from root to leaf forms a binary string and therefore a decimal value. Return the sum of all root to leaf paths using each path’s decimal value.
Note: It is guaranteed that the sum of all paths will fit in an integer value.

Ex: Given the following root…

     0
    / \
   1   1, return 2. (Our two paths are 01 and 01 which is 1 + 1 = 2).
Ex: Given the following root…

    1
   /  \
  1    0, return 5.

 */


import java.util.*;

class TreeNode {
	String value;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode(String ch) {
		this.value = ch;
	}
	TreeNode(String ch, TreeNode left, TreeNode right) {
		this.value = ch;
		this.left = left;
		this.right = right;
	}
}

public class BinaryTreeBinaryPaths {

	public static int findTheSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return dfsHelper(root, "");
	}

	public static int dfsHelper(TreeNode node, String current) {
		if (node == null)
			return 0;
		current += node.value;
		System.out.println("Debug dfs:" + current);
		if (node.left == null && node.right == null) {
			return getDecimal(current);
		}
		return dfsHelper(node.left, current) + dfsHelper(node.right, current);
	}

	public static int getDecimal(String current) {
		System.out.println(current);
		int length = current.length();
		int pow = 0;
		int decimal = 0;
		for (int i=length - 1; i>=0; i--) {
			char ch = current.charAt(i);
			int value = ch - '0';
			decimal += (value * (int)(Math.pow(2, pow++)));
		}
		return decimal;
	}

	public static void main(String [] args) {
		TreeNode root =  new TreeNode("0");
		root.left = new TreeNode("1");
		root.right = new TreeNode("1");
		System.out.println(findTheSum(root));
		TreeNode root1 = new TreeNode("1");
		root1.left = new TreeNode("1");
		root1.right = new TreeNode("1");
		root1.left.left = new TreeNode("0");
		root1.left.left.left = new TreeNode("0");
		System.out.println(findTheSum(root1));
	}
}