This question is asked by Amazon. Given two arrays of numbers, where the first array is a subset of the second array, return an array containing all the next greater elements for each element in the first array, in the second array. If there is no greater element for any element, output -1 for that number.

Ex: Given the following arrays…

nums1 = [4,1,2], nums2 = [1,3,4,2], return [-1, 3, -1] because no element in nums2 is greater than 4, 3 is the first number in nums2 greater than 1, and no element in nums2 is greater than 2.
nums1 = [2,4], nums2 = [1,2,3,4], return [3, -1] because 3 is the first greater element that occurs in nums2 after 2 and no element is greater than 4.



from collections import deque
def greaterElements(l1, l2):
	result = []
	dictionary = {}
	stack = deque()
	for element in l2:
		while stack and element > stack[-1]:
			dictionary[stack.pop()] = element
		stack.append(element)
	for element in l1:
		if element in dictionary:
			result.append(dictionary[element])
		else:
			result.append(-1)
	return result

l1 = [4, 1, 2]
l2 = [1, 3, 4, 2]
l3 = [2, 4]
l4 = [1, 2, 3, 4]
print(greaterElements(l1, l2))
print(greaterElements(l3, l4))
	
