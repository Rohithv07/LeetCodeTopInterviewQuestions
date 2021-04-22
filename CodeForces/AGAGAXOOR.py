test = int(input())
for i in range(test):
	n = int(input())
	nums = list(map(int, input().split()))
	setValue = set(nums)
	if len(setValue) == 1:
		print("YES")
		continue
	xor_value = 0
	for i in range(n):
		xor_value ^= nums[i]
	if (xor_value == 0):
		print("YES")
	else:
		k = 0
		count = 0
		for i in range(n):
			k ^= nums[i]
			if (k == xor_value):
				k = 0
				count += 1
		if (count > 2):
			print("YES")
		else:
			print("NO")