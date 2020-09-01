Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.

 

Example 1:

Input: [1,2,3,4]
Output: "23:41"
Example 2:

Input: [5,5,5,5]
Output: ""
 

Note:

A.length == 4
0 <= A[i] <= 9


Solution :

class Solution:
    def largestTimeFromDigits(self, A: List[int]) -> str:
        maximumTime = -1
        for h, i, j , k in itertools.permutations(A):
            hour = h * 10 + i
            minute = j * 10 + k
            if hour < 24 and minute < 60:
                maximumTime = max(maximumTime, hour*60+minute)
        if maximumTime == -1:
            return ''
        else:
            return "{:02d}:{:02d}".format(maximumTime // 60, maximumTime % 60)
