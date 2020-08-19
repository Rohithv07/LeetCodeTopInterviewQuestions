def minAbs(array):
    totalSum = sum(array) // 2
    totalLength = len(array) - 1
    dynamicArray = [[0 for i in range(totalSum+1)]for j in range(totalLength+1)]
    for i in range(totalLength+1):
        for j in range(totalSum+1):
            if i == 0 or j == 0:
                dynamicArray[i][j] = 0
            elif array[i-1] <= j:
                dynamicArray[i][j] = max(dynamicArray[i-1][j], array[i-1] + 
                                        dynamicArray[i-1][j-array[i-1]])
            else:
                dynamicArray[i][j] = dynamicArray[i-1][j]
    return (sum(array) - dynamicArray[-1][-1]) - dynamicArray[-1][-1]

array1 = [1,2,3,4,5]
array2 = [3,5,7,8]
print(minAbs(array1))
print(minAbs(array2))
