Given an array of numbers sorted in ascending order, return a height balanced binary search tree using every number from the array. Note: height balanced meaning that the level of any node’s two subtrees should not differ by more than one.

Ex: nums = [1, 2, 3] return a reference to the following tree...
       2
      /  \
     1    3
Ex: nums = [1, 2, 3, 4, 5, 6] return a reference to the following tree...
        3
       / \
     2    5
    /   /  \
  1    4    6



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
