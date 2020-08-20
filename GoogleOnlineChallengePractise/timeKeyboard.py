def keyboardTime(keyboard, text):
	dictionary = {}
	for i in range(26):
		dictionary[keyboard[i]] = i
	totalTime = 0
	currentIndex = 0
	for element in text:
		totalTime += abs(dictionary[element] - currentIndex)
		currentIndex = dictionary[element]

	return totalTime

keyboard = 'abcdefghijklmnopqrstuvwxyz'
text = 'cba'
print(keyboardTime(keyboard, text))