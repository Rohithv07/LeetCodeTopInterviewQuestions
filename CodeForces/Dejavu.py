def palindrome(s):
	return s == s[::-1]

test = int(input())
for i in range(test):
	s = input()
	count = 0
	for item in s:
		if item == 'a':
			count += 1
	if count == len(s):
		print("NO")
		continue
	if (palindrome(s)):
		s = s + 'a'
		print("YES")
		print(s)
		continue
	else:
		index = 0
		while (s[index] == 'a'):
			index += 1
		print("YES")
		new_s = s[0:len(s) - index] + 'a' + s[len(s) - index:]
		print(new_s)

