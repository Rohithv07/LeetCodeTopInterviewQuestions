test = int(input())

for t in range(test):
	n, m = map(int, input().split())
	dp = [1] * (n + 1)
	count = 0
	for i in range(2, n+1):
		value = m % i
		count = count + dp[value]
		for j in range(value, n + 1, i):
			dp[j] = dp[j] + 1
	print(count)