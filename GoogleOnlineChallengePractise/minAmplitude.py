def minAmplitude(array):
	lengthOfArray = len(array)
	array.sort()
	answer = array[lengthOfArray-1] - array[0]

	i = 0
	j = lengthOfArray - 4
	while (j < lengthOfArray):
		answer = min(answer, array[j] - array[i])
		i += 1
		j += 1
	return answer

li = [-1, 3, -1, 8, 5 ,4]
li2 = [10, 10, 3, 4, 10]
print(minAmplitude(li))
print(minAmplitude(li2))