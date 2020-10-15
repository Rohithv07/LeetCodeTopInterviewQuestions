https://www.hackerrank.com/challenges/is-binary-search-tree/problem

""" Node is defined as
class node:
  def __init__(self, data):
      self.data = data
      self.left = None
      self.right = None
"""
def check_binary_search_tree_(root):
    return dfs(root, -1, 100000)
def dfs(node, minimum, maximum):
    if node == None:
        return True
    if (node.data <= minimum or node.data >= maximum):
        return False
    return dfs(node.left, minimum, node.data) and dfs(node.right, node.data, maximum)
