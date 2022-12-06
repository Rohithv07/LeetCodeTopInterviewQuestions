Given a BST and an integer K. Find the Kth Smallest element in the BST using O(1) extra space. 

Example 1:

Input:
      2
    /   \
   1     3
K = 2
Output: 2
Explanation: 2 is the 2nd smallest element in the BST

Example 2:

Input:
        2
      /  \
     1    3
K = 5
Output: -1
Explanation: There is no 5th smallest element in the BST as the size of BST is 3
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function KthSmallestElement() which takes the root of the BST and integer K as inputs and return the Kth smallest element in the BST, if no such element exists return -1.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1<=Number of nodes<=100000


// User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;

//           public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    // Return the Kth smallest element in the given BST
    public int KthSmallestElement(Node root, int k) {
        // Write your code here
        if (root == null) {
            return -1;
        }
        int [] count = new int [1];
        int [] answer = new int [1];
        answer[0] = -1;
        inorder(root, count, k, answer);
        return answer[0];
    }
    
    private void inorder(Node node, int [] count, int k, int [] answer) {
        if (node == null) {
            return;
        }
        inorder(node.left, count, k, answer);
        count[0]++;
        if (count[0] == k) {
            answer[0] = node.data;
            return;
        }
        inorder(node.right, count, k, answer);
    }
}
