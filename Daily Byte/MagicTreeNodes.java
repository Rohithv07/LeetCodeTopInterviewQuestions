/*
Given the reference to a binary tree, return the total number of magic nodes in the tree.
Note: A node is magical if no value in the path from the root to the current node is greater than the current node’s value.

Ex: Given the following binary tree…

      1
    /   \
   2     3, return 3 (all nodes are magic nodes)
Ex: Given the following binary tree…

      5
    /   \
   4     9
  / \
 8   7, return 4 (5, 8, 7, and 9 are all magic nodes).
 */

 import java.util.*;

 public class MagicTreeNodes {

 	private static int magic = 1;
 	public static int magicNode(TreeNode root) {
 		if (root == null)
 			return 0;
 		int currentMax = root.val;
 		int previousMax = root.val;
 		dfs(root.left, currentMax, previousMax);
 		dfs(root.right, currentMax, previousMax);
 		return magic;
 	}

 	public static void dfs(TreeNode node, int currentMax, int previousMax) {
 		if (node == null) {
 			return;
 		}
 		int currentNodeValue = node.val;
 		if (currentMax < currentNodeValue && node.left == null && node.right == null) {
 			magic++;
 		}
 		else if (currentNodeValue > currentMax) {
 			magic++;
 			previousMax = currentMax;
 			currentMax = currentNodeValue;
 		}
 		dfs(node.left, currentMax, previousMax);
 		dfs(node.right, currentMax, previousMax);
 	}

 	public static void main(String [] args) {
 		// TreeNode root1 = new TreeNode(5);
 		// root1.left = new TreeNode(4);
 		// root1.right = new TreeNode(9);
 		// root1.left.left = new TreeNode(8);
 		// root1.left.right = new TreeNode(7);
 		// System.out.println(magicNode(root1));

 		TreeNode root2 = new TreeNode(5);
 		root2.left = new TreeNode(9);
 		root2.right = new TreeNode(7);
 		root2.left.left = new TreeNode(6);
 		root2.left.right = new TreeNode(8);
 		System.out.println(magicNode(root2));
 	}
 }


 class TreeNode {
 	int val;
 	TreeNode left;
 	TreeNode right;
 	public TreeNode(){}
 	public TreeNode(int val) {
 		this.val = val;
 	}
 	public TreeNode(int val, TreeNode left, TreeNode right) {
 		this.val = val;
 		this.right = right;
 		this.left = left;
 	}
 }