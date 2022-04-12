test = int(input())
for t in range(test):
	a, b, c, d = map(int, input().split())
	if b >= a:
		print(b)
		continue
	if c - d <= 0:
		print(-1)
		continue
	a -= b;
	diff = c - d
	print(b + (a + diff - 1) // diff * c)