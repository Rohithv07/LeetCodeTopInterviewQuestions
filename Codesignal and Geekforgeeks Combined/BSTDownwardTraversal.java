Given a Binary Search Tree and a target value. You have to find the node whose data is equal to target and return the sum of all descendant node's data which are vertically below the target node. Initially you are at the root node.
Note: If target node is not present in bst then return -1.

Example 1:

Input:


Target = 35
Output: 32
Explanation: Vertically below 35 is 32.
Example 2:

Input:

Target = 25
Output: 52
Explanation: Vertically below 25 is 22, 30 and their sum is 52.

Your Task:
You don't need to read input or print anything. Your task is to complete the function verticallyDownBST() which takes BST(you are given root node of bst ) and target as input, and return an interger value as the sum of vertically down nodes from target. If target is not present in bst then return -1.

Expected Time Complexity: O( n ), n is number of nodes.
Expected Auxiliary Space: O(Height of the tree).

Constraints:
1 <= n < 106
1 <= target <= n
1 <= node.data < 106

class Solution
{
    long verticallyDownBST(Node root,int target)
    {
        if (root == null) {
            return -1l;
        }
        Node targetNode = findTarget(root, target);
        if (targetNode == null) {
            return -1l;
        }
        long [] sumDescendant = new long [1];
        findSum(targetNode, 0, sumDescendant);
        return sumDescendant[0] - targetNode.data;
    }
    
    private Node findTarget(Node node, int target) {
        if (node == null) {
            return null;
        }
        if (node.data == target) {
            return node;
        }
        if (node.data > target) {
            return findTarget(node.left, target);
        }
        return findTarget(node.right, target);
    }
    
    private void findSum(Node node, int level, long [] sumDescendant) {
        if (node == null) {
            return;
        }
        if (level == 0) {
            sumDescendant[0] += node.data;
        }
        // towards left, consider it as moving towards negatives
        // towards right, consider it as moving towards positives
        findSum(node.left, level - 1, sumDescendant);
        findSum(node.right, level + 1, sumDescendant);
    }
}