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