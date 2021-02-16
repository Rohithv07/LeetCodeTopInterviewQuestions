def unique(s1, s2):
	s = len(set(s1 + s2))
	return s
test = int(input())
for t in range(test):
	n = int(input())
	words = input().split()
	count = 0
	dictionary = {}
	for word in words:
		remaining = word[1:]
		if remaining in dictionary:
			dictionary[remaining].append(word[0])
		else:
			dictionary[remaining] = [word[0]]
	listOfKeys = list(dictionary.keys())
	for i in range(len(dictionary)):
		for j in range(i + 1, len(dictionary)):
			distinct = unique(dictionary[listOfKeys[i]], dictionary[listOfKeys[j]])
			count += (distinct - len(dictionary[listOfKeys[i]])) * (distinct - len(dictionary[listOfKeys[j]]))
	print(count * 2)
