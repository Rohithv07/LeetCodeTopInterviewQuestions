Given a binary tree, connect the nodes that are at same level. You'll be given an addition nextRight pointer for the same.

Initially, all the nextRight pointers point to garbage values. Your function should set these pointers to point next right for each node.
       10                       10 ------> NULL
      / \                       /      \
     3   5       =>     3 ------> 5 --------> NULL
    / \     \               /  \           \
   4   1   2          4 --> 1 -----> 2 -------> NULL

 

Example 1:

Input:
     3
   /  \
  1    2
Output:
3 1 2
1 3 2
Explanation:The connected tree is
        3 ------> NULL
     /    \
    1-----> 2 ------ NULL
Example 2:

Input:
      10
    /   \
   20   30
  /  \
 40  60
Output:
10 20 30 40 60
40 20 60 10 30
Explanation:The connected tree is
         10 ----------> NULL
       /     \
     20 ------> 30 -------> NULL
  /    \
 40 ----> 60 ----------> NULL
Your Task:
You don't have to take input. Complete the function connect() that takes root as parameter and connects the nodes at same level. The printing is done by the driver code. First line of the output will be level order traversal and second line will be inorder travsersal

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ Number of nodes ≤ 105
0 ≤ Data of a node ≤ 105


//User function Template for Java

 /*
    Node class is Defined as follows:
    class Node{
        int data;
        Node left;
        Node right;
        Node nextRight;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
            nextRight = null;
        }
    }
    */
    
class Solution
{
    //Function to connect nodes at same level.
    public void connect(Node root)
    {
        // Your code goes here.
        if (root == null) {
            return;
        }
        Node nodeAtCurrentLevel = root;
        Node previous = null;
        Node nextEnd = null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left != null) {
                queue.offer(current.left);
                nextEnd = current.left;
            }
            if (current.right != null) {
                queue.offer(current.right);
                nextEnd = current.right;
            }
            if (previous != null) {
                previous.nextRight = current;
            }
            if (current == nodeAtCurrentLevel) {
                current.nextRight = null;
                previous = null;
                nodeAtCurrentLevel = nextEnd;
            }
            else {
                // previous == null
                previous = current;
            }
            
        }
    }
}