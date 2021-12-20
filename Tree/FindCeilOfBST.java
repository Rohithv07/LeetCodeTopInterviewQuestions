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



// just the logic, not the complete program
// ceil means the smallest number which is >= key
class FindCeilOfBST {
	public int findCeil(TreeNode root, int key) {
		if (root == null) {
			return -1;
		}
		int ceil = -1;
		while (root != null) {
			if (root.value == key) {
				return root.value;
			}
			if (root.value > key) {
				ceil = root.value;
				root = root.left; // as we need to find the smallest one
			}
			else {
				root = root.right;
			}
		}
		return ceil;
	}
}