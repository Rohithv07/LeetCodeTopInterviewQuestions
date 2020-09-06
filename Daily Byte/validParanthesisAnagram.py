This question is asked by Google. Given a string only containing the following characters (, ), {, }, [, and ] return whether or not the opening and closing characters are in a valid order.

Ex: Given the following strings...

"(){}[]", return true
"(({[]}))", return true
"{(})", return false



from collections import deque

def validBrackets(s):
	if s == 0:
		return True
	stack = deque()
	dictionaryOfBrackets = {'(': ')', '{': '}', '[': ']'}
	for elements in s:
		if elements in dictionaryOfBrackets:
			stack.append(elements)
		elif stack:
			if dictionaryOfBrackets[stack.pop()] != elements:
				return False
		else:
			return False
	return len(stack) == 0


s1 = '(){]'
s2 = '[({})]'
s3 = '(({[]}))'

print(validBrackets(s1))
print(validBrackets(s2))
print(validBrackets(s3))
