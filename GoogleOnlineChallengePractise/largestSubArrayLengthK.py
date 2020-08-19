"""
def largestSubArrayLengthK(array, k):
	if len(array) == 0 or len(array)== 1:
		return array
	firstIndex = 0
	for i in range(1, len(array) - k + 1):
		for count in range(k):
			if (array[firstIndex + count] < array[i + count]):
				firstIndex = i
			elif (array[firstIndex + count] > array[i + count]):
				break
			else:
				continue

	return array[firstIndex:firstIndex+k]

array = [1,4,3,2,5]
array2 = [9,1,2,8,7,6,5]
array3 = [1,1,2]
print(largestSubArrayLengthK(array, 4))
print(largestSubArrayLengthK(array2, 4))
print(largestSubArrayLengthK(array3, 2))
"""

def largestSubArrayLengthK(array, k):
	if len(array) == 0 or len(array) == 1:
		return array
	sumTemp = 0
	results = []
	for i in range(len(array) - k + 1):
		end = i + k
		currentArraySum = sum(array[i:end])
		if sumTemp < currentArraySum:
			results = array[i:end]
			sumTemp = currentArraySum

	return results

array = [1,4,3,2,5]
array2 = [9,1,2,8,7,6,5]
array3 = [1,1,2]
print(largestSubArrayLengthK(array, 4))
print(largestSubArrayLengthK(array2, 4))
print(largestSubArrayLengthK(array3, 2))