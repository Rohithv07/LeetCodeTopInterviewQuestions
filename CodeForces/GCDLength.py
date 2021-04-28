test = int(input())
for i in range(0, test):
	a, b, c = map(int, input().split())
	if a == 1 and b == 1 and c == 1:
		print("1 1")
		continue
	x = 10 ** (a - 1)
	y = 10 ** (b - 1)
	z = 10 ** (c - 1)
	print(f"{x} {y + z}")

