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

	TreeNode deleteNode(int key, TreeNode root) {
		if (root == null)
			return null;
		if (root.value < key)
			root.right = deleteNode(key, root.right);
		else if (root.value > key)
			root.left = deleteNode(key, root.left);
		else {
			if (root.left == null)
				return root.right;
			if (root.right == null)
				return root.left;
			TreeNode minimum = findMinimum(root.right);
			root.value = minimum.value;
			root.right = deleteNode(key, root.right);
		}
		return root;
	}

	TreeNode findMinimum(TreeNode node) {
		while (node != null)
			node = node.left;
		return node;
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
		tree.root = tree.deleteNode(60, tree.root);
		tree.inorderPrint();
	}


}