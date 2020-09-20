Given a binary search tree that contains unique values and two nodes within the tree, a, and b, return their lowest common ancestor. Note: the lowest common ancestor of two nodes is the deepest node within the tree such that both nodes are descendants of it.

Ex: Given the following tree...
       7
      / \
    2    9
   / \ 
  1   5 
and a = 1, b = 9, return a reference to the node containing 7.
Ex: Given the following tree...

        8
       / \
      3   9
     / \ 
    2   6
and a = 2, b = 6, return a reference to the node containing 3.
Ex: Given the following tree...

        8
       / \
      6   9
and a = 6, b = 8, return a reference to the node containing 8.



public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null)
			return null;
		if (a.val < root.val && b.val < root.val)	
			return lowestCommonAncestor(root.left, a, b);
		if (a.val > root.val && b.val > root.val)
			return lowestCommonAncestor(root.right, a, b);
		return root;
	}
}
