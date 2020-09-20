Given a binary search tree, return its mode (you may assume the answer is unique). If the tree is empty, return -1. Note: the mode is the most frequently occurring value in the tree.

Ex: Given the following tree...

        2
       / \
      1   2
return 2.

Ex: Given the following tree...

         7
        / \
      4     9
     / \   / \
    1   4 8   9
               \
                9  
return 9.

class TreeNode:
	def __init__(self, val=0, left=None, right=None):
		self.val = val
		self.left = left
		self.right = right
		
class Solution:
	def findMode(self, root:TreeNode) -> List[int]:
		if root == None:
			return []
		result = []
		dictionary = {}
		def dfs(root):
			if root == None:
				return None
			if root.val in dictionary:
				dictionary[root.val] += 1
			else:
				dictionary[root.val] = 1
			dfs(root.left)
			dfs(root.right)
		dfs(root)
		maximum = 0
		for key, value in dictionary.items():
			if maximum < value:
				maximum = value
		for key, value in dictionary.items():
			if value == maximum:
				result.append(key)
		return result
