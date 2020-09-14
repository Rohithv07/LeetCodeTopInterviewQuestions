This question is asked by Google. Given the reference to the root of a binary search tree and a search value, return the reference to the node that contains the value if it exists and null otherwise.
Note: all values in the binary search tree will be unique.

Ex: Given the tree...

        3
       / \
      1   4
and the search value 1 return a reference to the node containing 1.
Ex: Given the tree

        7
       / \
      5   9
         / \ 
        8   10
and the search value 9 return a reference to the node containing 9.
Ex: Given the tree

        8
       / \
      6   9
and the search value 7 return null.


class BST:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def findValue(self, node:BST, val:int) -> BST:
        if node == None:
            return None
        while (node):
            if node.val == val:
                return node
            elif node.val > val:
                self.findValue(node.left, val)
            else:
                self.findValue(node.right, val)
        return None
