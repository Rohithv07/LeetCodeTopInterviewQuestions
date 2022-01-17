Given a binary tree with a value associated with each node, we need to choose a subset of these nodes such that sum of chosen nodes is maximum under a constraint that no two chosen node in subset should be directly connected that is, if we have taken a node in our sum then we can’t take its any children or parents in consideration and vice versa.

                                               

Example 1:

Input:
     11
    /  \
   1    2
Output: 11
Explanation: The maximum sum is sum of
node 11.
Example 2:

Input:
        1
      /   \
     2     3
    /     /  \
   4     5    6
Output: 16
Explanation: The maximum sum is sum of
nodes 1 4 5 6 , i.e 16. These nodes are
non adjacent.
Your Task:
You don't need to read input or print anything. You just have to complete function getMaxSum() which accepts root node of the tree as parameter and returns the maximum sum as described.

Expected Time Complexity: O(Number of nodes in the tree).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 ≤ Number of nodes in the tree ≤ 10000
1 ≤ Value of each node ≤ 100000



class Solution
{
    //Function to return the maximum sum of non-adjacent nodes.
    static int getMaxSum(Node root)
    {
        // add your code here
        if (root == null) {
            return 0;
        }
        int [] withAndWithoutRoot = dfs(root);
        return Math.max(withAndWithoutRoot[0], withAndWithoutRoot[1]);
    }
    
    static int [] dfs(Node node) {
        if (node == null) {
            return new int []{0, 0};
        }
        int [] left = dfs(node.left);
        int [] right = dfs(node.right);
        int withRoot = left[1] + right[1] + node.data;
        int withoutRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int []{withRoot, withoutRoot};
    }
}
