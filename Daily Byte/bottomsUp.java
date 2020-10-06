Given a binary tree, returns of all its levels in a bottom-up fashion (i.e. last level towards the root). Ex: Given the following tree…

        2
       / \
      1   2
return [[1, 2], [2]]
Ex: Given the following tree…

       7
      / \
    6    2
   / \ 
  3   3 
return [[3, 3], [6, 2], [7]]

       7
      / \
    6    2    -> 7 != null -> size(result) == level -> add new (0, new ArrayList()) -> [[7]] 
   / \ 		-> 6 != null -> == LEVEL -> add new (0, arraylist()     -> [[6],[7]]
  3   3		->3 and then 3 
			3!=null -> size == level -> add new (0, arralist) -> result.get(sizem- level -1) ->[[3,3], [6,2], [7]] -> thsi is the final answr
      		-> 2 != null -> size == level -> add new (0, arrayList()) -> result.get(size-level-1) [[6, 2],[7]]


// 1. We are doing a dfs from root witht starting leveol = 0;
// 2. Inside the dfs , we will be updating our result list.
// 3. Whenever we have size == level, we increment our size.
// 4. Then we get the poisition(size-level-1) as we need it in the bottom up ie, we ned to add in the first index. and add the element
// 5. Continue dfs with left and right child with increase level.
// time complexity - O(n) and space O(width)


// we can also make use of BFS Here. Just do the normal level order traversal add the each values to the zeroth index


// DFS SOlution
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
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>(); // this is our resukt list
		dfs(root, 0, result); // our dfs function starting from the root and lvel = 0
		return result; // final result;
	}
	public void dfs(TreeNode node, int level, List<List<Integer>> result) {
		if (node == null) //  no element
			return; 
		if (result.size() == level)
			result.add(0, new ArrayList()); // a new list gets added at index 0;
		result.get(result.size()-level-1).add(node.val); // add to the zeroth index 
		dfs(node.left, level+1, result); // dfs on left
		dfs(node.right, level+1, result);// dfs on right
	}
}


// BFS SOlution

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
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> current = new ArrayList<>();
            for (int i=0; i<size; i++) {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                current.add(queue.poll().val);
            }
            result.add(0, current);
        }
        return result;
    }
}


