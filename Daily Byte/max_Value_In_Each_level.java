Given a binary tree, return the largest value in each of its levels. Ex: Given the following tree…

    2
   / \
  10  15
        \
         20
return [2, 15, 20]
Ex: Given the following tree…

          1
         / \
        5   6
       / \   \  
      5   3   7 
return [1, 6, 7]

 2
/ \     -> 2 - 2,   10, max =10 -. 15 max(max, 10) = 15 _. 15 store
10 15
    \20

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// 1. A List<Integr> to store the result.
// 2. We can do a bfs here, so we need a queue to store the nodes.
// 3. We loop until the queue is empty 
		// -> for i -> size(queue)
		// -> Store current value to maximum
		// -> check for left and right child and update the maximum
		// add the maximum on th result
// 4. Return the result.

// time : O(noOfNode) Space : O(widthOfTree) for dfs space is O(height)

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // 1. result list
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>(); // 2. Queue to deal witht the bfs
		queue.offer(root); // we use offer instead of add beacuse if no space is availabe, then offer returns false, add returns an exception
		while (!queue.isEmpty()) {
			int maximum = Integer.MIN_VALUE;
			int size = queue.size();
			for (int i=0; i<size; i++) {
				if (queue.peek().left != null) // if have a left child, offer it into the queue
					queue.offer(queue.peek().left);  // [2] -> [2, 10]     
				if (queue.peek().right != null) // if we have a right child, offer it into the queue
					queue.offer(queue.peek().right); // [2] -> [2,10] -> [2, 10, 15];
				maximum = Math.max(maximum, queue.poll().val);
			}
			result.add(maximum);
		}
		return result;
    }
}
