Given a binary tree, return a list containing its inorder traversal without using recursion.

Ex: Given the following tree…

      2     
     / \   
    1   3
return [1, 2, 3]
Ex: Given the following tree…

        2
       / \
      1   7
     / \
    4   8
return [4, 1, 8, 2, 7]



import java.util.*;

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode(int value) {
		this.value = value;
		left = right = null;
    }
}
class BinaryTree {
	TreeNode root;
	public void inorder() {
		if (root == null)
			return ;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		while (current != null || stack.size() > 0) {
			while (current != null) {
				// so push the left most child until it becomes null
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			System.out.println(current.value);
			// now we visited every left, now its rights turn
			current = current.right;
		}
	}
	public static void main(String [] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(2);
		tree.root.left = new TreeNode(1);
		tree.root.right = new TreeNode(7);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(8);
		tree.inorder();
	}
}