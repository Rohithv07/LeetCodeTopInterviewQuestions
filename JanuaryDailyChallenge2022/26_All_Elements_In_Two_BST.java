Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

 

Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:


Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
 

Constraints:

The number of nodes in each tree is in the range [0, 5000].
-105 <= Node.val <= 105


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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        List<Integer> node1List = new ArrayList<>();
        List<Integer> node2List = new ArrayList<>();
        inorder(root1, node1List);
        inorder(root2, node2List);
         if (node1List == null && node1List == null) {
            return result;
        }
        if (node1List == null) {
            return node2List;
        }
        if (node2List == null) {
            return node1List;
        }
        merge(node1List, node2List, result);
        return result;
    }
    
    public void inorder(TreeNode node1, List<Integer> list) {
        if (node1 == null) {
            return;
        }
        inorder(node1.left, list);
        list.add(node1.val);
        inorder(node1.right, list);
    }
    
    public void merge(List<Integer> list1, List<Integer> list2, List<Integer> result) {
        int i = 0;
        int j = 0;
        int size1 = list1.size();
        int size2 = list2.size();
        while (i < size1 && j < size2) {
            int val1 = list1.get(i);
            int val2 = list2.get(j);
            if (val1 < val2) {
                result.add(val1);
                i++;
            }
            else {
                result.add(val2);
                j++;
            }
        }
        while (i < size1) {
            result.add(list1.get(i));
            i++;
        }
        while (j < size2) {
            result.add(list2.get(j));
            j++;
        }
    }
}