Given a Binary Search Tree. Find sum of all elements smaller than and equal to Kth smallest element.

Example 1:

Input: 
          20
        /    \
       8     22
     /    \
    4     12
         /    \
        10    14   , K=3

Output: 22
Explanation:
Sum of 3 smallest elements are: 
4 + 8 + 10 = 22
Example 2:
Input:
     10
    /  \
   5    11
  / \ 
 4   7
      \
       8 , K=2

Output: 9
Explanation:
The sum of two smallest elements 
is 4+5=9.
 
Your task:
You don't need to read input or print anything. Your task is to complete the function sum() which takes the root node and an integer K as input parameters and returns the sum of all elements smaller than and equal to kth smallest element.
 
Expected Time Complexity: O(K)
Expected Auxiliary Space: O(1)
 
Constraints:
1<=Number of nodes in BST<=100
1<=K<=N
  




//User function Template for Java

/*
class Node {
    int data;
    Node left, right;
    Node(int key){
        this.data = key;
        this.left = this.right = null;
    }
}
*/

class Tree {
    int sum(Node root, int k) { 
        
        // Code here
        int [] sum = new int [1];
        int [] temp = new int [1];
        temp[0] = k;
        inorder(root, temp, sum);
        if (temp[0] > 1) {
            return -1;
        }
        return sum[0];
    } 
    
    private void inorder(Node node, int [] temp, int [] sum) {
        if (node == null) {
            return;
        }
        inorder(node.left, temp, sum);
        if (temp[0] > 0) {
            sum[0] += node.data;
            temp[0]--;
        }
        inorder(node.right, temp, sum);
    }
}