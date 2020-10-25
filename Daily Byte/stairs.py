"""This question is asked by Google. Given a staircase with N steps and the ability to climb either one or two steps at a time, return the total number of ways to arrive at the top of the staircase.

Ex: Given the following value of N…

N = 2, return 2
1 step + 1 step
2 steps
Ex: Given the following value of N…

N = 3, return 3
1 step + 1 step + 1 step
1 step + 2 steps
2 steps + 1 step

"""

# So as base case we can have if N =1, 1 N=2, 2 N=3,3.
# He can jump either two steps or 1 steps
# If a person is at say ith position f(i) = f(i-1) // f(i-2)
# So if we see the pattern its similar to fibanocci, ie either 1 step or two step.
# So it can be done in two ways.

#1st way
"""
def stairs(n):
	if n == 1 or n == 2 or n == 3:
		return n
	a, b = 1, 1
	for i in range(n):
		a, b = b, a+b
	return a

print(stairs(2))
print(stairs(10)
"""

#2nd way is to use memoisation concept where we actually store the previous state
def stairs(n):
	memo = {1:1, 2:2, 3:3}
	if (n < 4):
		return memo[n]
	if n not in memo:
		memo[n] = stairs(n-1) + stairs(n-2)
	return memo[n]
print(stairs(10))








