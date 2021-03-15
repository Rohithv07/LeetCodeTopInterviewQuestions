class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode(int value) {
		this.value = value;
	}
	TreeNode(int value, TreeNode left, TreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

class BinarySearchTree {
	TreeNode root;
	BinarySearchTree() {
		this.root = null;
	}

	void insertToBST(int key) {
		root = insertRecursively(root, key);
	}

	TreeNode insertRecursively(TreeNode node, int key) {
		if (node == null) {
			node = new TreeNode(key);
			return node;
		}
		if (node.value > key) {
			node.left = insertRecursively(node.left, key);
		}
		else {
			node.right = insertRecursively(node.right, key);
		}
		return node;
	}

	void inorderPrint() {
		inorderTraversalHelper(root);
	}

	void inorderTraversalHelper(TreeNode root) {
		if (root != null) {
			inorderTraversalHelper(root.left);
			System.out.println(root.value);
			inorderTraversalHelper(root.right);
		}
	}

	boolean searchAKey(int key) {
		return isPresent(key, root);
	}

	boolean isPresent(int key, TreeNode node) {
		if (node == null)
			return false;
		if (node.value == key)
			return true;
		if (node.value < key)
			return isPresent(key, node.right);
		return isPresent(key, node.left);
	}
	public static void main(String [] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insertToBST(50);
		tree.insertToBST(30);
		tree.insertToBST(20);
		tree.insertToBST(40);
		tree.insertToBST(70);
		tree.insertToBST(60);
		tree.insertToBST(80);
		tree.inorderPrint();
		System.out.println(tree.searchAKey(40));
		System.out.println(tree.searchAKey(100));
	}


}