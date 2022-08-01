Given a BST and a value k, the task is to delete the nodes having values greater than or equal to k.

Example 1:

Input:
    4   
   / \  
  1   9 
k = 2 
Output:
1
Your Task:
The task is to complete the function deleteNode() which takes root, k as the argument, and returns the root of tree after deleting values greater than or equal to k. The driver code will print the inorder traversal of the updated tree in output itself.

Expected Time Complexity: O(Size of tree)
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 103
1 <= A[] <= 103
1 <= k <= N


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}
*/
class Solution
   {
     public Node deleteNode(Node root,int k)
     {
     //add code here.
         if (root == null) {
             return root;
         }
         if (root.data >= k) {
             Node left = deleteNode(root.left, k);
             return left;
         }
         else {
             root.right = deleteNode(root.right, k);
         }
         return root;
     
     }
   }