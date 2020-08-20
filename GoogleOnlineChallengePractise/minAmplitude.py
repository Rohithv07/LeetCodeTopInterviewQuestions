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


def minAmp(array):
    if len(array) <= 4:
        return 0
    array.sort()
    minamp1 = max(array[3:]) - min(array[3:]) # 3 from left
    minamp2 = max(array[:-3]) - min(array[:-3]) # remove 3 from right
    minamp3 = max(array[2:-1]) - min(array[2:-1]) # remove 2 from left and 1 from right
    minamp4 = max(array[1:-2]) - min(array[1:-2]) # remove 1 from lefy and 2 from right
    
    return min(minamp1, minamp2, minamp3, minamp4)

array1 = [-1,3,-1,8,5,4]
array2 = [10,10,3,4,10]
print(minAmp(array1))
print(minAmp(array2))


