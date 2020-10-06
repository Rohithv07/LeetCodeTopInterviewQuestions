Given a binary tree, return its column order traversal from top to bottom and left to right. Note: if two nodes are in the same row and column, order them from left to right.

Ex: Given the following tree…

    8
   / \
  2   29
     /  \
    3    9
return [[2], [8, 3], [29], [9]]
Ex: Given the following tree…

     100
    /   \
  53     78
 / \    /  \
32  3  9    20
return [[32], [53], [100, 3, 9], [78], [20]]

Time - O(node)
Space - O(height)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        dictionary = collections.defaultdict(list)
        def dfs(node, x, y):
            if node == None:
                return
            dictionary[x].append((y, node.val))
            dfs(node.left, x-1, y+1)
            dfs(node.right, x+1, y+1)
        dfs(root, 0, 0)
        return [[val for i, val in sorted(v)]for key, v in sorted(dictionary.items())]
