Given a binary tree you need to check if it follows max heap property or not.

Input:
The task is to complete the method which takes one argument, root of Binary Tree. The struct Node has a data part which stores the data, pointer to left child and pointer to right child.There are multiple test cases. For each test case, this method will be called individually.

Output:
The function should return true if property holds else false.
 

Example 1:

Input:
      5
    /  \
   2    3
Output: 1
Example 2:

Input:
       10
     /   \
    20   30 
  /   \
 40   60
Output: 0
Constraints:
1 ≤ Number of nodes ≤ 100
1 ≤ Data of a node ≤ 1000



// User Function template for JAVA

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
* It should be a complete tree (i.e. all levels except last should be full).
* Every node’s value should be greater than or equal to its child node (considering max-heap).
*/
class Solution {
    boolean isHeap(Node tree) {
        // code here
        if (tree == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(tree);
        boolean hasNoLeft = false;
        boolean hasNoRight = false;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if ((current.left != null && current.right != null)
            && (hasNoLeft || hasNoRight)) {
                return false;
            }
            boolean hasLeft = false;
            if (current.left != null) {
                hasLeft = true;
                if (current.left.data <= current.data) {
                    queue.offer(current.left);
                }
                else {
                    return false;
                }
            }
            else {
                hasNoLeft = true;
            }
            if (current.right != null) {
                if (!hasLeft) {
                    return false;
                }
                if (current.right.data <= current.data) {
                    queue.offer(current.right);
                }
                else {
                    return false;
                }
            }
            else {
                hasNoRight = true;
            }
        }
        return true;
    }
}