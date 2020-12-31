class Solution:
	# @param A : list of integers
	# @return an integer
	def largestRectangleArea(self, heights):
	    heights.append(0)
	    answer = 0
	    stack = [-1]
	    for i in range(len(heights)):
	        while heights[i] < heights[stack[-1]]:
	            h = heights[stack.pop()]
	            w = i - stack[-1] - 1
	            answer = max(answer, h * w)
	        stack.append(i)
	    heights.pop()
	    return answer
	   

