def waterPlant(plant, capacity1, capacity2):
	if len(plant) == 0:
		return 0
	temp1 = 0
	temp2 = 0
	counter = 0
	left = 0
	right = len(plant) - 1
	while (left < right):
		if temp1 < plant[left]:
			temp1 = capacity1
			counter += 1
		if temp2 < plant[right]:
			temp2 = capacity2
			counter += 1
		temp1 -= plant[left]
		temp2 -= plant[right]
		left += 1
		right -= 1
	if left == right and plant[left] > temp1 + temp2:
		counter += 1
	return counter

plant = [2,4,5,1,2]
capacity1 = 5
capacity2 = 7
print(waterPlant(plant, capacity1, capacity2))
