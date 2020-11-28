# Singly-linked lists are already defined with this interface:
# class ListNode(object):
#   def __init__(self, x):
#     self.value = x
#     self.next = None
#
def findMiddleElement(l):
    first = l
    second = l
    
    if l is not None:
        while first is not None and first.next is not None:
            first = first.next.next
            second = second.next 
            
    return second.value


# Singly-linked lists are already defined with this interface:
# class ListNode(object):
#   def __init__(self, x):
#     self.value = x
#     self.next = None
#
def findMiddleElement(l):
    temp = l 
    count = 0
    while l:
        if count % 2 != 0:
            temp = temp.next
        l = l.next
        count += 1
    
    return temp.value
