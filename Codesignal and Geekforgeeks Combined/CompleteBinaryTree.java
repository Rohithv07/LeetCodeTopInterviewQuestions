Given a Binary Tree, write a function to check whether the given Binary Tree is Complete Binary Tree or not. A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.


Example 1:
Input:
       1
      / \
     2   3
Output:
Complete Binary Tree
Example 2:

Input:
              1
            /   \
          2      3
           \    /  \
            4  5    6
Output:
Not Complete Binary Tree
Constraints:
1<=Number of Node<=100
0 <= Data of a node <= 106

Your Task:
You don't need to take input. Just complete the function isCompleteBT() that takes root node as a parameter and returns true, if the tree is Complete else returns false.


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
class GfG
{
	boolean isCompleteBT(Node root)
    {
          //add code here.
          if (root == null) {
              return true;
          }
          Queue<Node> queue = new LinkedList<>();
          queue.offer(root);
          boolean isComplete = false;
          while (!queue.isEmpty()) {
              Node current = queue.poll();
              if (current == null) {
                  isComplete = true;
              }
              else {
                  if (isComplete) {
                      return false;
                  }
                  queue.offer(current.left);
                  queue.offer(current.right);
              }
          }
          return true;
	} 
	
}