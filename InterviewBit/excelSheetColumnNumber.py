class Solution:
	# @param A : string
	# @return an integer
	def titleToNumber(self, A):
	    result = 0
	    for element in A:
	        result = result * 26 + (ord(element) - ord('A')) + 1
	    return result

