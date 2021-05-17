test = int(input())
for t in range(test):
	n = int(input())
	mod = (10 ** 9) + 7
	x = 2
	y = n - 1
	result = 1
	while y > 0:
		if y % 2 != 0:
			result = (result * x) % mod
		x = x * x
		y = y // 2
	print(result % mod)
		