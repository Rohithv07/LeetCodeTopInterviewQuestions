
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        
        if not head:
            return head
        slow = head
        fast = head
        while (fast != None and fast.next != None):
            slow = slow.next
            fast = fast.next.next
        node1 = head
        node2 = self.reverse(slow.next)
        slow.next = None
        while node2:
            node1.next, node1 = node2, node1.next
            node2.next, node2 = node1, node2.next

        
        
    def reverse(self, node):
            current = node
            previous = None
            while(current):
                currentNext = current.next
                current.next = previous
                previous = current
                current = currentNext
            return previous
