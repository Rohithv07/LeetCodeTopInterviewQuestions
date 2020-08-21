def minNoChair(entryTime, exitTime):
	
	combinedEntryExit = [(en, 1) for en in entryTime] + [(ex, -1) for ex in exitTime]
	combinedEntryExit.sort()

	maximumPossible = 0
	currentEntry = 0
	for entryExit, flag in combinedEntryExit:
		currentEntry += flag
		if maximumPossible < currentEntry:
			maximumPossible = currentEntry
	return maximumPossible
	

	"""
	dicitonary = {}
	count = 0
	result = 0
	for i in range(len(entryTime)):
		if entryTime[i] not in dicitonary:
			dicitonary[entryTime[i]] = 0
		else:
			dicitonary[entryTime[i]] += 1
		if exitTime[i] not in dicitonary:
			dicitonary[exitTime[i]] = 0
		else:
			dicitonary[exitTime[i]] += 1
	for key, value in dicitonary.items():
		count += value
		result = max(result, count)
	return result
	"""

S = [1, 2, 6, 5, 3, 4]
E = [5, 5, 7, 6, 8, 7]
print(minNoChair(S, E))