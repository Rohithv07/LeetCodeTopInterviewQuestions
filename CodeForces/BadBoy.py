test = int(input())
for t in range(test):
	n, m, i, j = map(int, input().split())
	print(f"1 1 {n} {m}")

# Idea is simple, keep one yoyo in topleft corener and other in bottom right corner