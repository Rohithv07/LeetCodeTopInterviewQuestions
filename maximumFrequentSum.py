The sum of a subtree is the sum of all the node values in that subtree, including its root.

Given a binary tree of integers, find the most frequent sum (or sums) of its subtrees.

Example

For
t = {
    "value": 1,
    "left": {
        "value": 2,
        "left": null,
        "right": null
    },
    "right": {
        "value": 3,
        "left": null,
        "right": null
    }
}
the output should be
mostFrequentSum(t) = [2, 3, 6].
1st example

Since all the sum values in this tree occur only once, return all of them in ascending order.

For
t = {
    "value": -2,
    "left": {
        "value": -3,
        "left": null,
        "right": null
    },
    "right": {
        "value": 2,
        "left": null,
        "right": null
    }
}
the output should be
mostFrequentSum(t) = [-3].
2nd example

There are 3 subtree sums for this tree: -2 + (-3) + 2 = -3, -3, and -2. The most frequent sum is -3 since it appears twice.


# Solution:

#
# Binary trees are already defined with this interface:
# class Tree(object):
#   def __init__(self, x):
#     self.value = x
#     self.left = None
#     self.right = None
import collections
def mostFrequentSum(t):
    if not t:
        return []
        
    D = collections.defaultdict(int)
    def dfs_call_sum(node):
        if not node:
            return 0
        rv = node.value + dfs_call_sum(node.left) + dfs_call_sum(node.right)
        D[rv] += 1
        return rv
    dfs_call_sum(t)
    maximum =  max(D.values())
    result = [k for k, v in D.items() if v == maximum]
    
    return sorted(result)
