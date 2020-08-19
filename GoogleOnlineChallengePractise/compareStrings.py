def compareStrings(str1, str2):
	str1 = str1.split(',')
	str2 = str2.split(',')
	store = [0] * 11
	finalResult = []
	for element in str1:
		minimumFrequency = element.count(min(element))
		store[minimumFrequency] += 1
	for element in str2:
		minimumFrequency = element.count(min(element))
		finalResult.append(sum(store[:minimumFrequency]))
	return finalResult

str1 = 'abcd,aabc,bd'
str2 = 'aaa,aa'
print(compareStrings(str1, str2))
print(compareStrings(str3, str4))
