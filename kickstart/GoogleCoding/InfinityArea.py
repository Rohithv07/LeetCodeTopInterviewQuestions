import math

def findarea(r):
	return math.pi * r * r


test = int(input())
for t in range(1, test + 1):
	r, a, b = map(int, input().split())
	right = False
	area = findarea(r)
	while r != 0:
		if right == False:
			r = r * a
			area = area + findarea(r)
			right = True
		else:
			r = r // b
			area = area + findarea(r)
			right = False
	print(f"Case #{t}: {area}")

