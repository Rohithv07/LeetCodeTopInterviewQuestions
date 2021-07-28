test = int(input())
for t in range(test):
	n = int(input())
	if n % 3 == 0:
		print(f"{n//3} {n//3}")
	elif n % 3 == 1:
		print(f"{n//3 + 1} {n//3}")
	elif n % 3 == 2:
		print(f"{n//3} {n//3 + 1}")