class Solution:
	# @param A : string
	# @return an integer
	def romanToInt(self, s):
        dictionary = {"I" : 1, "V" : 5, "X" : 10, "L" : 50, "C" : 100, "D" : 500, "M" : 1000}
        s = s[::-1] # reverse
        result = dictionary[s[0]]
        for i in range(1, len(s)):
            if (dictionary[s[i]] >= dictionary[s[i - 1]]):
                result += dictionary[s[i]]
            else:
                result -= dictionary[s[i]]
        return result
