Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:


Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Constraints:

The number of nodes in the tree is in the range [2, 100].
1 <= Node.val <= 100
Each node has a unique value.
x != y
x and y are exist in the tree.


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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            boolean xLevelSame = false;
            boolean yLevelSame = false;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode current = queue.poll();
                if (current.val == x) {
                    xLevelSame = true;
                }
                if (current.val == y) {
                    yLevelSame = true;
                }
                if (current.left != null && current.right != null) {
                    if (current.left.val == x && current.right.val == y) {
                        return false;
                    }
                    if (current.right.val == x && current.left.val == y) {
                        return false;
                    }
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            if (xLevelSame && yLevelSame) {
                return true;
            }
            if (xLevelSame || yLevelSame) {
                return false;
            }
        }
        return false;
    }
}




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
    private int leftDepth = -1;
    private int rightDepth = -2;
    private TreeNode leftParent = null;
    private TreeNode rightParent = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        dfs(root, null, x, y, 0);
        return leftDepth == rightDepth && leftParent != rightParent;
    }
    
    public void dfs(TreeNode node, TreeNode parent, int x, int y, int depth) {
        if (node == null) {
            return;
        }
        if (node.val == x) {
            leftParent = parent;
            leftDepth = depth;
        }
        else if (node.val == y) {
            rightParent = parent;
            rightDepth = depth;
        }
        dfs(node.left, node, x, y, depth + 1);
        dfs(node.right, node, x, y, depth + 1);
    }
}