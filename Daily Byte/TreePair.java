import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode(int val) {
		this.val = val;
	}
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class TreePair {

	public static boolean isTargetPresent(TreeNode root, int target) {
		if (root == null)
			return false;
		Set<Integer> set = new HashSet<>();
		return dfs(root, set, target);
	}

	public static boolean dfs(TreeNode root, Set<Integer>set, int target) {
		if (root == null)
			return false;
		if (set.contains(target - root.val))
			return true;
		set.add(root.val);
		return dfs(root.left, set, target) || dfs(root.right, set, target);
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(7);
		int target = sc.nextInt();
		System.out.println(isTargetPresent(root, target));
	}
}