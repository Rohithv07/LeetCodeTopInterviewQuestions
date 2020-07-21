Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Solution:


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        first = head
        second = head
        counter = 1
        while counter <= n:
            second = second.next
            counter += 1
        
        if second is None:
            return head.next
        while second.next is not None:
            second = second.next
            first = first.next
        first.next = first.next.next
            
        return head


