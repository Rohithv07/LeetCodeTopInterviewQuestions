Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]



Solution:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        
        def dfsTraversal(node, level, res):
            if not node:
                return 
            if len(res) < level + 1:
                res.append([])
            res[level].append(node.val)
            dfsTraversal(node.left, level+1, res)
            dfsTraversal(node.right, level+1, res)
            
        dfsTraversal(root, 0, res)
        return res
