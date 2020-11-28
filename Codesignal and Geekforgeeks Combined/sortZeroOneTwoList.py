Note: Try to solve this task in linear time, since this is what you'll be asked to do during an interview.

Given a singly linked list consisting only of 0, 1, and 2, return it sorted in ascending order.

Example

For l = [2, 1, 0], the output should be
sortZeroOneTwoList(l) = [0, 1, 2];
For l = [0, 1, 0, 1, 2, 0], the output should be
sortZeroOneTwoList(l) = [0, 0, 0, 1, 1, 2].

Solution:
# Singly-linked lists are already defined with this interface:
# class ListNode(object):
#   def __init__(self, x):
#     self.value = x
#     self.next = None
#
def sortZeroOneTwoList(head):
    if head == None or head.next == None:
        return head
    # 1. Create three nodes
    zeroD = ListNode(0)
    oneD = ListNode(0)
    twoD = ListNode(0)
    
    zero = zeroD
    one = oneD
    two = twoD
    
    current = head
    while(current):
        # If we find value zero move to zero, if 1 move to one , if 2 move to two
        if current.value == 0:
            zero.next = current
            zero = zero.next
            current = current.next
        elif current.value == 1:
            one.next = current
            one = one.next
            current = current.next
        else:
            two.next = current
            two = two.next
            current = current.next
    
    # Attach three node
    if (oneD.next):
        zero.next = oneD.next
    else:
        zero.next = twoD.next
    one.next = twoD.next
    two.next = None
    
    head = zeroD.next
    return head
