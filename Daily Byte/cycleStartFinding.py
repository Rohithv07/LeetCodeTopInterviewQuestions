This question is asked by Apple. Given a potentially cyclical linked list where each value is unique, return the node at which the cycle starts. If the list does not contain a cycle, return null.

Ex: Given the following linked lists...

1->2->3, return null
1->2->3->4->5->2 (5 points back to 2), return a reference to the node containing 2
1->9->3->7->7 (7 points to itself), return a reference to the node containing 7

class ListNode:
	def __init__(self, x):
		self.x = x
		self.next = None

def cycleStartFinder(head:ListNode):
	if head == None or head.next == None:
		return None
	slow = head
	fast = head
	while fast != None and fast.next != None:
		slow = slow.next
		fast = fast.next.next
		if slow == fast:
			return slow
	return None

# Time complexity O(n) Space O(1)

def cycleStartFinder2(head:ListNode):
	if head == None or head.next == None:
		return None
	dictionary = collections.defaultdict(ListNode)
	while head:
		if head in dictionary:
			return head
		dictionary[head] = True
		head = head.next
	return None
