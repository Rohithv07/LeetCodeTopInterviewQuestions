This question is asked by Microsoft. Given a linked list, containing unique numbers, return whether or not it has a cycle.
Note: a cycle is a circular arrangement (i.e. one node points back to a previous node)

Ex: Given the following linked lists...

1->2->3->1 -> true (3 points back to 1)
1->2->3 -> false
1->1 true (1 points to itself)


class ListNode:
	def __init__(self, x):
		self.x = x
		self.next = None

def containsCycle(head:ListNode):
	if head == None or head.next == None:
		return False

	slow = head
	fast = head
	while(fast != None and fast.next != None):
		slow = slow.next;
		fast = fast.next.next

		if slow == fast:
			return True
	return False

 # One solution with O(n) time and O(1) space

 def containsCycle(head):
 	if head == None or head.next == None:
		return False
 	dictionary = collections.defaultdict(ListNode)
 	while head:
 		if head in dictionary:
 			return True
 		dictionary[head] = True
 		head = head.next
 	return False

# 2nd Solution with O(n) time and O(n) space.
