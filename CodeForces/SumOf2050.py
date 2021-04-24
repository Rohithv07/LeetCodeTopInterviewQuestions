test = int(input())
for i in range(test):
	n = int(input())
	if (n % 2050 != 0):
		print("-1");
	else:
		x = n // 2050
		answer = 0
		while (x > 0):
			answer += x % 10
			x = x // 10
		if answer == 0:
			print("1")
		else:
			print(answer)

