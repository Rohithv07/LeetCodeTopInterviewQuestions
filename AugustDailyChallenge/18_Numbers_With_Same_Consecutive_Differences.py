Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.

Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.

You may return the answer in any order.

 

Example 1:

Input: N = 3, K = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
Example 2:

Input: N = 2, K = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 

Note:

1 <= N <= 9
0 <= K <= 9


class Solution:
    def numsSameConsecDiff(self, N: int, K: int) -> List[int]:
        if N == 1:
            return [i for i in range(10)]
        
        answer = []
        def dfsHelper(N, num):
            if N == 0:
                return answer.append(num)
            tail = num % 10
            nextDigits = set([tail + K, tail - K])
            for nextDigit in nextDigits:
                if 0 <= nextDigit < 10:
                    newNumber = num * 10 + nextDigit
                    dfsHelper(N-1, newNumber)
        for num in range(1, 10):
            dfsHelper(N-1, num)
        return list(answer)
