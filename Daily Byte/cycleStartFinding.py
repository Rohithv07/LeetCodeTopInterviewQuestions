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