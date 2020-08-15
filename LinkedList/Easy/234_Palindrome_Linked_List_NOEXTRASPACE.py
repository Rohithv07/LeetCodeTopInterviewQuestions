# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if head is None or head.next is None:
            return True
        
        slow = head
        fast = head
        
        while(fast is not None and fast.next is not None):
            slow = slow.next
            fast = fast.next.next
            
        slow = self.reverseList(slow)
        fast = head
        
        while(slow):
            if slow.val != fast.val:
                return False
            slow = slow.next
            fast = fast.next
            
        return True
    
    def reverseList(self, node):
        current = node
        previous = None
        
        while(current):
            currentNext = current.next
            current.next = previous
            previous = current
            current = currentNext
            
        return previous
