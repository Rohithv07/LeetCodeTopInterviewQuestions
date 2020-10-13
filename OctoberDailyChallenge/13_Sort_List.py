Given the head of a linked list, return the list after sorting it in ascending order.

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []




# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        middle = self.findMiddle(head)
        nextToMiddle = middle.next
        middle.next = None
        
        left = self.sortList(head)
        right = self.sortList(nextToMiddle)
        
        return self.mergeAndSort(left, right)
    
    def findMiddle(self, node):
        if node is None and node.next == None:
            return node
        slow = node
        fast = node
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        return slow
    def mergeAndSort(self, node1, node2):
        result = None
        if node1 == None:
            return node2
        if node2 == None:
            return node1
        if node1.val <= node2.val:
            result = node1
            result.next = self.mergeAndSort(node1.next, node2)
        else:
            result = node2
            result.next = self.mergeAndSort(node1, node2.next)
        return result
