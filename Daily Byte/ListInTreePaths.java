/*
Given the reference to the root of a binary tree and the reference to the head of a linked list, return whether or not the entire linked list appears as a subpath within the tree.

Ex: Given the following root and head…

      root = 1
            / \
           2   3
          /
         3
      head = 1 -> 2 -> 3, return true
Ex: Given the following root and head…

      root = 4
            / \
           2   7
          /
         3
      head = 2 -> 3 -> 4, return false.
*/



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private List<TreeNode> storeList = new ArrayList<>();
    public boolean isSubPath(ListNode head, TreeNode root) {
        storeToList(head, root);
        for (TreeNode node : storeList) {
            if (isSubPathTrue(head, node))
                return true;
        }
        return false;
    }
    
    public void storeToList(ListNode head, TreeNode root) {
        if (head == null || root == null)
            return;
        if (head.val == root.val)
            storeList.add(root);
        storeToList(head, root.left);
        storeToList(head, root.right);
    }
    
    public boolean isSubPathTrue(ListNode current, TreeNode node) {
        if (current == null)
            return true;
        if (node == null)
            return false;
        if (current.val == node.val) {
            return isSubPathTrue(current.next, node.left) || isSubPathTrue(current.next, node.right);
        }
        return false;
    }
}
