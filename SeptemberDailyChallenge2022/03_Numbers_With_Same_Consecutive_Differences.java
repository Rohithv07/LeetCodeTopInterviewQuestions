Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.

Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.

You may return the answer in any order.

 

Example 1:

Input: n = 3, k = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
Example 2:

Input: n = 2, k = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 

Constraints:

2 <= n <= 9
0 <= k <= 9


class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            // we are already taking 1 digit, so n - 1.
            findAllNumbers(n - 1, k, result, i);
        }
        int length = result.size();
        int [] finalResult = new int [length];
        for (int i = 0; i < length; i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
    
    private void findAllNumbers(int n, int k, List<Integer> result, int number) {
        if (n < 1) {
            result.add(number);
            return;
        }
        int lastDigit = number % 10;
        int possible1 = lastDigit + k;
        int possible2 = lastDigit - k;
        if (possible1 < 10) {
            findAllNumbers(n - 1, k, result, number * 10 + possible1);
        }
        if (possible2 >= 0 && k != 0) {
            findAllNumbers(n - 1, k, result, number * 10 + possible2);
        }
    }
    
}