test = int(input())

for t in range(test):
	n = int(input())
	count = 0
	while n // 2 > 0:
		count += 1
		n = n // 2
	print((2 ** count) - 1)