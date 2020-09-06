from collections import deque
def buildString(s):
	stack = deque()
	for element in s:
		if element != '#':
			stack.append(element)
		elif stack:
			stack.pop()
	return ''.join(stack)

def compareKeyStrokes(s, t):
	return buildString(s) == buildString(t)

s1 = "ABC#"
t1 = "CD##AB"
s2 = "como#pur#ter"
t2 = "computer"
s3 = "cof#dim#ng"
t3 = "code"
print(compareKeyStrokes(s1, t1))
print(compareKeyStrokes(s2, t2))
print(compareKeyStrokes(s3, t3))