/*
Given the root of two binary trees, a and b, return the resulting tree when you overlay a on top of b.
Note: For any nodes that overlap a is placed on top of b, the resulting tree’s node should contain their sum.

Ex: Given the following a and b…

a = 1     b = 4
   / \       / \
  2   3     5   6, return the resulting tree...
           5 (1 + 4)
         /   \
(2 + 5) 7     9 (3 + 6)
Ex: Given the following a and b…

a = 7     b = 9
   / \       /
  2   1     5, return the resulting tree...
         16
        /  \
       7    1
*/



class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	public TreeNode() {}
	public TreeNode(int value) {
		this.value = value;
	}
	public TreeNode(int value, TreeNode left, TreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

public class OverlayTree {

	public static void inorder(TreeNode node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.value + " ");
		inorder(node.right);
	}

	public static TreeNode mergeTheTree(TreeNode node1, TreeNode node2) {
		if (node1 == null)
			return node2;
		if (node2 == null)
			return node1;
		node1.value += node2.value;
		node1.left = mergeTheTree(node1.left, node2.left);
		node1.right = mergeTheTree(node1.right, node2.right);
		return node1;
	}

	public static void main(String [] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		root1.right.right = new TreeNode(6);
		
		TreeNode root2 = new TreeNode(4);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(7);
		root2.left.left = new TreeNode(3);
		root2.right.left = new TreeNode(2);
		root2.right.right = new TreeNode(6);

		TreeNode root3 = mergeTheTree(root1, root2);
		inorder(root3);

		TreeNode root4 = new TreeNode(7);
		root4.left = new TreeNode(2);
		root4.right = new TreeNode(1);
		TreeNode root5 = new TreeNode(9);
		root5.left = new TreeNode(5);
		TreeNode root6 = mergeTheTree(root4, root5);
		inorder(root6);
	}
}
