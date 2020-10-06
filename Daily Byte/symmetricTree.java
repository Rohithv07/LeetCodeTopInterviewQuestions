Given a binary tree, return whether or not it forms a reflection across its center (i.e. a line drawn straight down starting from the root).
Note: a reflection is when an image, flipped across a specified line, forms the same image.

Ex: Given the following tree…

   2
 /   \
1     1
return true as when the tree is reflected across its center all the nodes match.
Ex: Given the following tree…

    1
   / \
  5   5
   \    \
    7    7
return false as when the tree is reflected across its center the nodes containing sevens do not match.

    1   -> So here when we fold the tree from the centre, there must be identical. But here 7 will not be identical because we have right(5) = 7
   / \		and also on the right side, we also have right(5) = 7 which is not the condition. we look left(5) on left side == right(5) on the right
  5   5		side.
   \    \
    7    7

// Here we can do 2 methods, dfs and bfs.
//1. DFS. We pass two nodes on to the recursive function and starts by checking whether node1 and node2 == null, then return true.
// 2. If both not null, then we check whenther the value are equal, if yes, then do recursive(node.left, node.right) and recursive(node.right, node.left)
//  3. This will return true, if it is symmetrical

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class Solution {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return dfs(root, root)
	}
	public boolean dfs(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 != null && node2 == null) {
			if (node1.val == node2.val)
				return dfs(node1.left, node2.right) && dfs(node2.left, node1.right);
		}
		return false;
	}
}




// Another solution is BFS
// We can store the TreeNode values inside a queue and check whether the two values are equal or not or also both nodes are null valeus.
    1
   / \    -> Queue -> [1] ->pops 1 ->[5, 5, null, null]
  5   5	  -> Queue ->[5, 5, null, null] - pops 5, 5 -> [null, null] pops them also and updaye by [null, 7, 7, null]. But here 7 != null so return false;
   \    \
    7    7

public boolean symmetric(TreeNode root) {
	if (root == null)
		return true;;
	Queue<TreeNode> queue = new LinkedList<>();
	queue.add(root);
	while (!queue.isEmpty()) {
		int size = queue.size();
		for (int i=0; i<size; i++) {
			TreeNode t1 = queue.poll();
			TreeNode t2 = queue.poll();
			if (t1 == null && t2 == null)
				continue;
			if (t1 == null || t2 == null)
				return false;
			if (t1.val != t2.val)
				return false;
			queue.offer(t1.left);
			queue.offer(t2.right);
			queue.offer(t1.right);
			queue.offer(t2.left); 
		}
	}
	return true;
}























