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

Solution:
"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        """
        We need to know the root whether has the right children.
        Then we just connect the left children to the right children.
        If the right children need to connect to another node, the condition is that its root.next is not empty and the             root.next has left children.
        Then we can connect them, otherwise just need to make the right children's next to null.
        I think it's a straightforward way.
        """
        if root == None:
            return None
        if root.left != None:
            root.left.next = root.right
        
        if root.right != None and root.next != None and root.left.next != None:
            root.right.next = root.next.left
            
        self.connect(root.left)
        self.connect(root.right)
        
        return root
