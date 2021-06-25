def countOnes(arr):
	i = 0
	j = 0
	n = len(arr)
	zeroCount = 0
	currentValue = 0
	maxValue = 0
	while (j < n):
		if arr[j] == 0:
			if zeroCount == 0:
				zeroCount += 1
				j += 1
			else:
				while(arr[i] != 0):
					i += 1
					currentValue -= 1
				i += 1
				j += 1
		else:
			currentValue += 1
			j += 1
		maxValue = max(currentValue, maxValue)
	if maxValue == n:
		return maxValue - 1
	else:
		return maxValue

arr = [0, 1, 1, 0, 1]
print(countOnes(arr))