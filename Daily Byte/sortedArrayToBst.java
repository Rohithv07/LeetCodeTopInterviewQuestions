
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) {
		this.val = val;
	}
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = vall;
		this.left = left;
		this.right = right;
	}
}

class Solution {
	public TreeNode sortedArrayToBst(int [] array) {
		if (array == null)
			return null;
		return convert(array, 0, array.length-1);
	}
	public TreeNode convert(int [] array, int low, int high) {
		if (left > high)
			return null;
		int middle = (low + high) / 2;
		TreeNode node = new TreeNode(array[middle]);
		if (low == high)
			return node;
		node.left = convert(array, low, middle-1);
		node.right = convert(array, middle+1, high);
		return node;
	}
}
