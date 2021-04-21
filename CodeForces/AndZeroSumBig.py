import math

def findTheAnswer(n, k):
	answer = 1
	for i in range(0, k):
		answer = (answer % (10 ** 9 + 7)) * (n % (10 ** 9 + 7))
	return answer % (10 ** 9 + 7)

test = int(input())
for i in range(test):
	n, k = (map(int, input().split()))
	print(findTheAnswer(n, k))