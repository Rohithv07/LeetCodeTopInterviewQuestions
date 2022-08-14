Given a binary tree and data value of two of its nodes. Find the number of turns needed to reach from one node to another in the given binary tree.

Example 1:

Input:      
Tree = 
           1
        /    \
       2       3
     /  \     /  \
    4    5   6    7                        
   /        / \                        
  8        9   10   
first node = 5
second node = 10
Output: 4
Explanation: 
Turns will be at 2, 1, 3, 6.
Example 2:

Input:      
Tree = 
           1
        /     \
       2        3
     /  \      /  \
    4    5    6    7                        
   /         / \                        
  8         9   10   
first node = 1
second node = 4  
Output: -1
Explanation: No turn is required since 
they are in a straight line.

Your Task:  
You don't need to read input or print anything. Complete the function NumberOFTurns() which takes root node and data value of 2 nodes as input parameters and returns the number of turns required to navigate between them. If the two nodes are in a straight line, ie- the path does not involve any turns, return -1.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of Tree)


Constraints:
1 ≤ N ≤ 103


//User function Template for Java
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
/*
First of all find the lowest common ancestor (LCA) of the nodes of given values.

From the LCA node try to reach the given two nodes and count the no. of turns in the path.
We'll do this using preorder traversal.

Let's say f = number of turns from the LCA node to ‘first’ node and s = number of turns from 
the LCA node to ‘second’ node. If the LCA node is one of the two given nodes then either
f=0 or s=0 cause turns to reach from a node to itself is 0. So in that case the answer would be 
f+s which is nothing but turns to reach from ‘first’ node to ‘second’ node. But if the LCA node is 
not one of the two given nodes then the answer would be f+s+1 cause one extra turn is there. 
The two given nodes are not in the same subtree. Either the ‘first’ node is in left subtree of LCA 
node and the ‘second’ node is in the right subtree of LCA node or vice versa. So one extra turn would 
be there at the LCA node.
*/



class Solution
{
    static int Count = 0;
   static int NumberOfTurns(Node root, int first, int second)
   {
       //your code here
       Count = 0;
       Node lca = findLCA(root,first,second);
       if(lca.data == first){
           CountTurn(lca.right,second,false);
           CountTurn(lca.left,second,true);
       }
       else if(lca.data == second){
           CountTurn(lca.right,first,false);
           CountTurn(lca.left,first,true);
       }else{
           CountTurn(lca.right,first,false);
           CountTurn(lca.left,first,true);
           CountTurn(lca.right,second,false);
           CountTurn(lca.left,second,true);
            return  Count+1;
       }
       return  Count;
   }
   
 // function count number of turn need to reach
   // given node from it's LCA we have two way to
   static boolean CountTurn(Node root, int key, boolean turn) {
       if (root == null)
           return false;

       // if found the key value in tree
       if (root.data == key)
           return true;

       // Case 1:
       if (turn == true) {
           if (CountTurn(root.left, key, turn))
               return true;
           if (CountTurn(root.right, key, !turn)) {
               Count += 1;
               return true;
           }
       } else // Case 2:
       {
           if (CountTurn(root.right, key, turn))
               return true;
           if (CountTurn(root.left, key, !turn)) {
               Count += 1;
               return true;
           }
       }
       return false;
   }
    
    static Node findLCA(Node node, int first, int second) {
        if (node == null) {
            return null;
        }
        if (node.data == first || node.data == second) {
            return node;
        }
        Node left = findLCA(node.left, first, second);
        Node right = findLCA(node.right, first, second);
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return node;
        }
        if (left != null) {
            return left;
        }
        return right;
    }
}