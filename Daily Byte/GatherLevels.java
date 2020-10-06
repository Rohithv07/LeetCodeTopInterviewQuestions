Given a binary tree, return its level order traversal where the nodes in each level are ordered from left to right.

Ex: Given the following tree...

    4
   / \
  2   7
return [[4], [2, 7]]
Ex: Given the following tree...

    2
   / \
  10  15
        \
         20
return [[2], [10, 15], [20]]
Ex: Given the following tree...

    1
   / \
  9   32
 /     \
3       78
return [[1], [9, 32], [3, 78]]

[1] -> 1 -> [1, 9, 32] -> list.add(1) -> result
[9, 32] -> [9,32,3] -> lsit.add(9) 
[32, 3] -> 32 list.add(32)
[3, 78] -> 3 list.add(3)
[78] -> 78 list.add(78)
[] -> exit

1 , 9, 32, 3, 78

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){};
	TreeNode(int val){
		this.val = val;
	}
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Solution {
	public List<List<Integer>> gatherLevels(TreeNode root) {
		List<List<Integer>> result = new ArrayList(); // used to store the result
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>(); // used to do the bfs, store the treenode
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> currentLevel = new ArrayList<>(); // for storing the elements of the current level
			int size = queue.size();
			for (int i=0; i<size; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);  // if a left child for current element add it to the queue.
				if (queue.peek().right != null)
					queue.offer(queue.peek().right); // if a right child for current element add it to the queue.
				currentLevel.add(queue.poll().val);  // add the current level element to the list
			}
			result.add(currentLevel); // add all the elements stored for a particular level on to the final result
		}
		return result;
	}
}
		
