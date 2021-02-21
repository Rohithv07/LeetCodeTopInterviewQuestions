/*
Given a binary tree, count the total number of nodes it contains.

Ex: Given the following binary tree...

         1
        / \
       2   3, return 3. 
*/



import java.util.*;

class TreeNode  {
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


class CountNodes {

	public static int countAllNodes(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		int count = 0;
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			count += 1;
			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);
		}
		return count;
	}

	public static void main(String [] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(7);
        root.right = new TreeNode(5); 
        root.left.right = new TreeNode(6); 
        root.left.right.left = new TreeNode(1); 
        root.left.right.right = new TreeNode(11); 
        root.right.right = new TreeNode(9); 
        root.right.right.left = new TreeNode(4); 
        System.out.println(countAllNodes(root));
	}
}