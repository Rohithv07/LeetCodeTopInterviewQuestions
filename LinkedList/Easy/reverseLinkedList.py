Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

Solution: Iterative

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        current = head
        previous = None
        
        
        while current is not None:
            currentNext = current.next
            current.next = previous
            previous = current
            current = currentNext
            
        return previous
    
    
