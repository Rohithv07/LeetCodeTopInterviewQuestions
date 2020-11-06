""" Node is defined as
class node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
"""

def checkBST(root):
    if not root:
            return True
    return isValidNode(root,float('-inf'), float('inf'))
    
def isValidNode(root, l, r):
        if not root:
            return True
        return l<root.data<r and isValidNode(root.left, l, root.data) and isValidNode(root.right, root.data, r)
