n, query = map(int, input().split())
nums = list(map(int, input().split()))
q = map(int, input().split())
result = []
for item in q:
	for i in range(n):
		if (nums[i] == item):
			result.append(i + 1)
			nums[:i+1] = [item] + nums[:i]
			break
for item in result:
	print(f"{item} ", end = "")