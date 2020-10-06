Given a binary tree, containing unique values, determine if it is a valid binary search tree.
Note: the invariants of a binary search tree (in our case) are all values to the left of a given node are less than the current node’s value, all values to the right of a given node are greater than the current node’s value, and both the left and right subtrees of a given node must also be binary search trees.

Ex: Given the following binary tree…

   1
 /   \
2     3
return false.
Ex: Given the following tree…

   2
 /   \
1     3
return true.


   1
 /   \    -> We can validate bst as to the left of root all values are small and to the right all valies are large
2     3	  -> Here 1 is the root and 1 is < 2 which is not the condition fo the bst so we can return false;
-> On the second tesy case, root is 2 and 2 > 1, which is a valid conditon + 2 < 3 which is also a valid condtion. So return true.

// 1. Here can do dfs on the given tree, check whether the val on the left < root and value on the right > root.
// 2. If both of the condition satisfies, return true, else return false.


// Time complexity O(node), space complexity O(height)
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){};
	TreeNode(int val){this.val = val;}
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
public class Solution {
    public boolean isValidBST(TreeNode root) {
		return dfs(root, Long.MIN_VALUE, Long. MAX_VALUE);
	}
	public boolean dfs(TreeNode node, long min, long max) {
		if (node == null)
			return true;
		if (node.val <= min || node.val >= max)
			return false;
		return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }
}
