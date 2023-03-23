You are given a Binary Search Tree and a target value. You must find the maximum difference between the sum of node data from root to target and from target to a child leaf node (target exclusive). Initially, you are at the root node.
Note: If the target node is not present in the tree then return -1.

Example 1:

Input:


Target = 20
Output: 10
Explanation: From root to target the sum of node data is 25 and from target to the children leaf nodes the sums of the node data are 15 and 25. So, the maximum difference will be (25-15) = 10.
Example 2:

Input:

Target = 50
Output: -1
Explanation: The target node is not present in the tree.

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxDifferenceBST() which takes BST(you are given the root node of the BST ) and target as input, and returns an interger value as the required answer. If the target is not present in the BST then return -1.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(H), H - Height of the Tree.


Constraints:
1 <= n < 10^4
1 <= node.data < 10^5
1 <= target < 10^5


// https://practice.geeksforgeeks.org/contest/weekly-interview-series-74/problems/#

// https://www.youtube.com/watch?v=NITqk6eSZ6k


class Solution
{
    public static int maxDifferenceBST(Node root,int target)
    {
        //Please code here
        if (root == null) {
            return -1;
        }
        long [] sumUpToTarget = new long [1];
        Node targetNode = findTarget(root, sumUpToTarget, target);
        if (targetNode == null) {
            return -1;
        }
        sumUpToTarget[0] -= (findSumAfterTarget(targetNode) - target);
        return (int)sumUpToTarget[0];
    }
    
    private static Node findTarget(Node node, long [] sum, int target) {
        if (node == null) {
            return null;
        }
        if (node.data == target) {
            return node;
        }
        sum[0] += node.data;
        if (node.data < target) {
            return findTarget(node.right, sum, target);
        }
        else {
            return findTarget(node.left, sum, target);
        }
    }
    
    private static long findSumAfterTarget(Node targetNode) {
        long min = Long.MAX_VALUE;
        if (targetNode.left != null) {
            // since its bst, left subtree will always give smaller result
            min = findSumAfterTarget(targetNode.left);
        }
        if (targetNode.right != null) {
            min = Math.min(min, findSumAfterTarget(targetNode.right));
        }
        if (min == Long.MAX_VALUE) {
            return targetNode.data;
        }
        return min + targetNode.data;
    }
}