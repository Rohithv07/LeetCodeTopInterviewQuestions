Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?

SOlution:

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
