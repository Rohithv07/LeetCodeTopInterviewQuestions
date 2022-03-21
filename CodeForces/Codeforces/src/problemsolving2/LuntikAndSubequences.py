test = int(input())
for t in range(0, test):
	n = int(input())
	nums = list(map(int, input().split()))
	countOfZero = 0
	countOfOne = 0
	for values in nums:
		if values == 0:
			countOfZero += 1
		elif values == 1:
			countOfOne += 1
	print((1 << countOfZero) * countOfOne)