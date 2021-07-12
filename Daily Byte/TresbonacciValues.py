n = int(input())

li = [0] * (n + 1)
li[0] = 0
li[1] = 1
li[2] = 1
for i in range(3, len(li)):
	li[i] = li[i - 1] + li[i - 2] + li[i - 3];
print(li[n])