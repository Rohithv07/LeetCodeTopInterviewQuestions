Given two binary trees with head reference as T and S having at most N nodes. The task is to check if S is present as subtree in T.
A subtree of a tree T1 is a tree T2 consisting of a node in T1 and all of its descendants in T1.

Example 1:

Input:
T:      1          S:   3
      /   \            /
     2     3          4
   /  \    /
  N    N  4
Output: 1 
Explanation: S is present in T

Example 2:

Input:
T:      26         S:   26
       /   \           /  \
     10     N        10    N
   /    \           /  \
   20    30        20  30
  /  \            /  \
 40   60         40  60
Output: 1 
Explanation: 
S and T are both same. Hence, 
it can be said that S is a subtree 
of T.
Your Task:
You don't need to read input or print anything. Your task is to complete the function isSubtree() that takes root node of S and T as parameters and returns 1 if S is a subtree of T else 0.


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 105
1 <= Value of nodes <= 104


//User function Template for Java

/*complete the given function*/

/* class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=null;
        right=null;
    }
}*/

class Solution {
    public static boolean isSubtree(Node node1, Node node2) {
        // add code here.
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (sameSubtree(node1, node2)) {
            return true;
        }
        return isSubtree(node1.left, node2) || isSubtree(node1.right, node2);
    }
    
    public static boolean sameSubtree(Node subTree1, Node subTree2) {
        if (subTree1 == null && subTree2 == null) {
            return true;
        }
        if (subTree1 == null || subTree2 == null) {
            return false;
        }
        if (subTree1.data != subTree2.data) {
            return false;
        }
        return sameSubtree(subTree1.left, subTree2.left) &&
        sameSubtree(subTree1.right, subTree2.right);
    }
}