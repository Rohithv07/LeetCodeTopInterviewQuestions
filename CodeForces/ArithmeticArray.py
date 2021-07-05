test = int(input())
for t in range(test):
	n = int(input())
	nums = list(map(int, input().split(" ")))
	totalSum = sum(nums)
	if totalSum >= n:
		print(totalSum - n)
	else:
		print(1)