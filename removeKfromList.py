Given a singly linked list of integers l and an integer k, remove all elements from list l that have a value equal to k.

Example

For l = [3, 1, 2, 3, 4, 5] and k = 3, the output should be
removeKFromList(l, k) = [1, 2, 4, 5];
For l = [1, 2, 3, 4, 5, 6, 7] and k = 10, the output should be
removeKFromList(l, k) = [1, 2, 3, 4, 5, 6, 7].



Solution:

# Singly-linked lists are already defined with this interface:
# class ListNode(object):
#   def __init__(self, x):
#     self.value = x
#     self.next = None
#
def removeKFromList(l, k):
    current = l
    while current is not None:
        if current.value != k:
            break
        current = current.next
        
    new_head = current
    prev = None
    while current is not None:
        if current.value == k:
            if prev is not None:
                prev.next = current.next
            current = current.next
            continue
        prev = current
        current = current.next
        
    return new_head
