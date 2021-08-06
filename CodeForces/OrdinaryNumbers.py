# https://codeforces.com/blog/entry/90342

test = int(input())
for t in range(test):
	n = int(input())
	count = 0
	i = 1
	while i <= n:
		for j in range(1, 10):
			if i * j <= n:
				count += 1
		i = i * 10 + 1
	print(count)
