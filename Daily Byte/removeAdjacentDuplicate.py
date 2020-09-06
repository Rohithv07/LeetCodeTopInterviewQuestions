"""This question is asked by Facebook. Given a string s containing only lowercase letters, continuously remove adjacent characters that are the same and return the result.

Ex: Given the following strings...

s = "abccba", return ""
s = "foobar", return "fbar"
s = "abccbefggfe", return "a"
"""

from collections import deque

def removeAdjacentDuplicates(s):
	stack = []
	for element in s:
		if not stack or stack[-1] != element:
			stack.append(element)
		elif stack and stack[-1] == element:
			stack.pop()

	return ''.join(stack)

s1 = "abccba"
s2 = "foobar"
s3 = "abccbefggfe"
s4 = "abbaca"

print(removeAdjacentDuplicates(s1))
print(removeAdjacentDuplicates(s2))
print(removeAdjacentDuplicates(s3))
print(removeAdjacentDuplicates(s4))