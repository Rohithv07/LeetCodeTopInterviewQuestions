Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
 

Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000


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
/*
So first of all we can find the leaf node using the dfs searcg and thus by tracking rhe count of depth and updatng whther it may be the minimum depth that we are looking for
*/

class Solution {
    public int minDepth(TreeNode root) {
        // base condition
        if (root == null)
            return 0;
        // check if the node we are currently in see the leaf node or not
        // leaf node means no left or right child
        if (root.left == null && root.right == null) 
            return 1;
        if (root.left == null)
            return minDepth(root.right) + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}

// time complexity = O(minimum(DepthLeafNode))
/*
Here we can also do BFS, consider a case where the root have say 10 nodes to the left and 1 node to the right.
So it will be doing dfs on the left, all the way down to 10, then only it would come up to the right and deal with that single node on right which is the minDepth what we require. So we can use level order traversal using the queue data structure, the BFS method to solve the same problem
*/
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            level += 1;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return level;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return level;
    }
}

// time complexity O(firstLeafNode)







