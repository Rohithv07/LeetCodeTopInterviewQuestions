test = int(input())
for i in range(test):
	n = int(input())
	s1 = input()
	s2 = input()
	xor = 0
	count0 = s1.count('0')
	count1 = s1.count('1')
	for i in range(len(s1)-1, -1, -1):
		if (int(s1[i]) ^ xor != int(s2[i])):
			if count0 != count1:
				print("NO")
				break
			xor = 1- xor
		count0 -= s1[i] == '0'
		count1 -= s1[i] == '1'
	else:
		print("YES")
