You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.


Solution:
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummyNode = ListNode(0)
        l3 = dummyNode
        carry = 0
        while(l1 != None or l2 != None):
            if (l1 != None):
                l1Value = l1.val
            else:
                l1Value = 0
            
            if (l2 != None):
                l2Value = l2.val
            else:
                l2Value = 0
            
            summation = l1Value + l2Value + carry
            carry = summation // 10
            lastDigit = summation % 10
            newLastDigitNode = ListNode(lastDigit)
            l3.next = newLastDigitNode
            
            if l1 != None:
                l1 = l1.next
            if l2 != None:
                l2 = l2.next
            l3 = l3.next
            
        if carry > 0:
            newPlaceDigit = ListNode(carry)
            l3.next = newPlaceDigit
            l3 = l3.next
            
        return dummyNode.next
