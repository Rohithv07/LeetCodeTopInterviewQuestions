test = int(input())
for t in range(0, test):
	li = list(map(int, input().split()))
	s = li[0] + (li[1] * 2) + (li[2] * 3)
	print(s % 2)