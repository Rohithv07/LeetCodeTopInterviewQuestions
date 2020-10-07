Given two binary trees, return whether or not both trees have the same leaf sequence. Two trees have the same leaf sequence if both trees’ leaves read the same from left to right.

Ex: Given the following trees…

   1
 /   \
1     3
and


   7
 /   \
1     2
return false as both the trees' leaves don't read the same from left to right (i.e. [1, 3] and [1, 2]).

Ex: Given the following trees…

    8
   / \
  2   29
    /  \
   3    9
and

    8
   / \
  2  29
 /   /  \
2   3    9
     \
      3
return true as both the trees' leaves read the same from left to right (i.e. [2, 3, 9] and [2, 3, 9]).


// dfs search is possible here.
// if both of the roots are null, return true, if any of the roots is null, return false.
// lets do the dfs on the left and right childs of both the tree and add that node value into the list if it is a leaf node.
// at last compare the two list that we used for storing the leaf node.

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){};
	TreeNode(int val) {this.val = val;}
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;	
	}
}
public class Solution {
	public boolean isSameLeaf(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		List<Integer> tree1 = new ArrayList<>(); // for storing the leaf node values of tree1
		List<Integer> tree2 = new ArrayList<>(); // for storing the leaf node values of tree2
		dfs(root1, tree1);
		dfs(root2, tree2); // fills both the list by doing depth first search on both trees.
		return tree1.equals(tree2); // check for equality and returns true if equal otherwise false
	}
	public void dfs(TreeNode root, List<Integer> treeLeafValues) {
		if (root != null) {
			if (root.left == null && root.right == null) // if we encounter a leaf node, we add those into the lsit.
				treeLeafValues.add(root.val);
			else {
				dfs(root.left, treeLeafValues);
				dfs(root.right, treeLeafValues);
			}
		}
	}
	
}


// time complexity -> O(tree1Node + tree2Node) space ->O(tree1width + tree2width)
