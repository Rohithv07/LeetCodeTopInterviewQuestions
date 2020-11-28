def unique(s):
	if (len(s) == 0):
		return True;
	if len(s) == 1:
		return True;
	array = [False] * 128
	for elements in s:
		if array[int(elements)] == True:
			return True
		array[int(elements)] = True
	return False


s1 = ""
s2 = "a"
s3 = "zbcdajb"
s4 = "abc"

print(unique(s1))
print(unique(s2))
print(unique(s3))
print(unique(s4))