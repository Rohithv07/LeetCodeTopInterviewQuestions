Given a Binary Search Tree and a range [low, high]. Find all the numbers in the BST that lie in the given range.
Note: Element greater than or equal to root go to the right side.

Example 1:

Input:
       17
     /    \
    4     18
  /   \
 2     9 
l = 4, h = 24
Output: 4 9 17 18 
Example 2:

Input:
       16
     /    \
    7     20
  /   \
 1    10
l = 13, h = 23
Output: 16 20 
Your Task:
You don't need to read input or print anything. Your task is to complete the function printNearNodes() which takes the root Node of the BST and the range elements low and high as inputs and returns an array that contains the BST elements in the given range low to high (inclusive) in non-decreasing order.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 ≤ Number of nodes ≤ 104
1 ≤ l ≤ h ≤ 105


class Solution
{   
    //Function to return a list of BST elements in a given range.
	public static ArrayList<Integer> printNearNodes(Node root,int low,int high) {
        // code here.
        if (root == null)
            return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        dfs(root, low, high, result);
        return result;
    }
    
    public static void dfs(Node node, int low, int high, ArrayList<Integer> result) {
        if (node == null)
            return;
        dfs(node.left, low, high, result);
        if (low <= node.data && high >= node.data) {
            result.add(node.data);
        }
        dfs(node.right, low, high, result);
        
    }
    
}