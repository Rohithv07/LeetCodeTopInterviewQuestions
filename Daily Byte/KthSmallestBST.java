/*
Given the reference to a binary search tree, return the kth smallest value in the tree.

Ex: Given the following binary search tree and value k…

    3
   / \
  2   4, k = 1, return 2.
Ex: Given the following binary search tree and value k…

    7
   / \
  3   9
   \
    5, k = 3, return 7.

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

 class KthSmallestBST {

 	public static int kthSmall(TreeNode root, int k) {
 		ArrayList<Integer> result = inOrder(root, new ArrayList<>());
 		return result.get(k - 1);
 	}

 	public static ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> array) {
 		if (root == null)
 			return null;
 		inOrder(root.left, array);
 		array.add(root.val);
 		inOrder(root.right, array);
 		return array;
 	}

 	public static void main(String [] args) {
 		TreeNode root = new TreeNode(5);
 		root.left = new TreeNode(3);
 		root.right = new TreeNode(6);
 		root.left.left = new TreeNode(2);
 		root.left.right = new TreeNode(4);
 		root.left.left.left = new TreeNode(1);
 		Scanner sc = new Scanner(System.in);
 		int k = sc.nextInt();
 		System.out.println(kthSmall(root, k));
 	}
 }