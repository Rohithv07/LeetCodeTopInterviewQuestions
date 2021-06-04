test = int(input())
for t in range(test):
	n = int(input())
	if n // 111 >= n % 11:
		print("YES")
	else:
		print("NO")
	