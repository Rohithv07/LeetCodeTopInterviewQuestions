"""
You are building a pool in your backyard and want to create the largest pool possible. The largest pool is defined as the pool that holds the most water. The workers you hired to dig the hole for your pool didn’t do a great job and because of this the depths of the pool at different areas are not equal. Given an integer array of non-negative integers that represents a histogram of the different heights at each position of the hole for your pool, return the largest pool you can create.

Ex: Given the following heights...

heights = [1, 4, 4, 8, 2], return 12. 
You can build your largest pool (most water) between indices 1 and 3 (inclusive) for a water volume of 4 * 3 = 12.
"""

class LargestPool:
	

	def largestPool(self, heights):
		heights.append(0)
		stack = [-1]
		answer = 0
		for i in range(len(heights)):
			while heights[i] < heights[stack[-1]]:
				h = heights[stack.pop()]
				w = i - stack[-1] - 1
				answer = max(answer, h * w)
			stack.append(i)
		heights.pop()
		return answer


largestpool = LargestPool()
height = [1, 4, 4, 8, 2]
print(largestpool.largestPool(height))