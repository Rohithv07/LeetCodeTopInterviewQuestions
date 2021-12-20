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


// only the logic, not the complete code
class FindKthLargestSmallestBST {

	public int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int [] level = new int []{0};
		int [] result = new int []{Integer.MIN_VALUE};
		inorder(root, k, level, result);
		return result[0];
	}

	public void inorder(TreeNode node, int k, int [] level, int [] result) {
		if (node == null) {
			return;
		}
		inorder(node.left, k, level, result);
		level[0] += 1;
		if (level[0] == k) {
			result[0] = node.val;
			return;
		}
		if (level[0] < k) {
			inorder(node.right, k, level, result);
		}
	}


	// to find the kth largest, we can just find the total number of nodes and reuse the inorder traversal above

	public int kthLargest(TreeNode root, int k) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int [] level = new int []{0};
		int [] result = new int []{Integer.MAX_VALUE};
		int [] totalNodes = new int []{0};
		findTotalNode(root, totalNodes);
		inorder(root, totalNodes[0] - k, level, result);
	}

	public void findTotalNode(TreeNode node, int [] totalNodes) {
		if (node == null) {
			return;
		}
		totalNodes ++ 1;
		findTotalNode(node.left, totalNodes);
		findTotalNode(node.right, totalNodes);
	}
}