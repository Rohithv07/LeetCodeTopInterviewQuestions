Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.

It is guaranteed that the answer will in the range of 32-bit signed integer.

 

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:


Input: root = [1,3,null,5,3]
Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:


Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
 

Constraints:

The number of nodes in the tree is in the range [1, 3000].
-100 <= Node.val <= 100




/*
Width can be seen as = index of rightmost node - index of leftmost node + 1
assign index to each node, similar as heap on a tree
root's index = 1, left child is 1 * 2, right child is 1 * 2 + 1, and so on...
*/


class Solution {
    public int widthOfBinaryTree(TreeNode root) {
       if (root == null) {
           return 0;
       }
        return helper(root, 0, 1, new ArrayList<Integer>());

    }
    private int helper(TreeNode root, int depth, int index, List<Integer> list) {
        if (root == null) {
            return 0;
        }
        if (depth == list.size()) {
            list.add(index);
        }
        int currWidth = index - list.get(depth) + 1;
        int leftWidth = helper(root.left, depth + 1, index * 2, list);
        int rightWidth = helper(root.right, depth + 1, index * 2 + 1, list);
        return Math.max(currWidth, Math.max(leftWidth, rightWidth));
    }
}