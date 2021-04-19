import math

def isPrime(n):
	if n <= 1:
		return False
	if (n <= 3):
		return True
	if (n % 2 == 0 or n % 3 == 0):
		return False
	i = 5
	while (i * i <= n):
		if n % i == 0 or n % (i + 2) == 0:
			return False
		i = i + 6
	return True

test = int(input())
for t in range(1, test+1):
	n = int(input())
	a1 = int(math.sqrt(n))
	a2 = a1 + 1
	while (not isPrime(a1)):
		a1 -= 1
	while (not isPrime(a2)):
		a2 += 1
	while (a1 * a2 > n):
		a2 = a1
		a1 -= 1
		while (not isPrime(a1)):
			a1 -= 1
	print(f"Case #{t}: {a1 * a2}")

