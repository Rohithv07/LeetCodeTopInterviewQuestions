test = int(input())
for t in range(0, test):
	n = int(input())
	nums = list(map(int,input().split()))
	nums.sort()
	largest = nums[n - 1]
	totalSum = 0
	for i in range(0, n - 1):
		totalSum += nums[i]
	average = (largest) + (totalSum / (n - 1))
	print(average)