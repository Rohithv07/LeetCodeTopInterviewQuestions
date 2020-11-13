You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 

Example 1:



Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 

Constraints:

The number of nodes in the given tree is less than 4096.
-1000 <= node.val <= 1000




// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};



// 1. Extra space
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        // we add root and null
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            // 1st case we reached the end of the tree
            if (current == null && queue.isEmpty())
                return root;
            // 2nd if we reached particular position of the tree but not the end
            else if (current == null) {
                // then add null to the queue
                queue.offer(null);
                continue;
            }
            // 3rd we want to set the next pointer for the current to the first element of the queue
            // and add the elements left and right child on to the queue
            else {
                current.next = queue.peek();
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
        }
        return root;
    }
}



// Constant space
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        // we make use of 2 variable of type Node both initialy pointing to root
        Node start = root;
        Node left = root;
        while(start.left != null) {
            while (start != null) {
                start.left.next = start.right;
                if (start.next != null)
                    start.right.next = start.next.left;
                start = start.next;
            }
            start = left.left;
            left = start;
        }
        return root;
    }
}
