You are climbing a staircase that has n steps. You can take the steps either 1 or 2 at a time. Calculate how many distinct ways you can climb to the top of the staircase.

Example

For n = 1, the output should be
climbingStairs(n) = 1;

For n = 2, the output should be
climbingStairs(n) = 2.

You can either climb 2 steps at once or climb 1 step two times.

Solution:

def climbingStairs(n):
    """a, b = 1, 1
    for i in range(n):
        a, b = b, a+b
    return a
    """
    def dynamicWay(n):
        if n not in memo:
            memo[n] = dynamicWay(n-1) + dynamicWay(n-2)
        return memo[n]
    memo = {1:1, 2:2}
    return dynamicWay(n)
    
