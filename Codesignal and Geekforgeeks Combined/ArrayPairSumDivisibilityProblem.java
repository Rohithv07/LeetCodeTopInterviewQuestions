Given an array of integers and a number k, write a function that returns true if given array can be divided into pairs such that sum of every pair is divisible by k.
 

Example 1 :

Input : arr = [9, 5, 7, 3], k = 6
Output: True
Explanation: {(9, 3), (5, 7)} is a 
possible solution. 9 + 3 = 12 is divisible
by 6 and 7 + 5 = 12 is also divisible by 6.

Example 2:

Input : arr = [2, 4, 1, 3], k = 4
Output: False
Explanation: There is no possible solution.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function canPair() which takes array and k as input parameter and returns true if array can be divided into pairs such that sum of every pair is divisible by k otherwise returns false.
 

Expected Time Complexity: O(n)
Expected Space Complexity : O(n)
 

Constraints:
1 <= length of array <= 10^5
1 <= elements of array <= 10^5
1 <= k <= 10^5


class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        int [] remainder = new int [k];
        for (int num : nums) {
            int rem = num % k;
            remainder[rem]++;
        }
        if (remainder[0] % 2 == 1) {
            return false;
        }
        for (int i = 1; i < k; i++) {
            if (remainder[i] != remainder[k - i]) {
                return false;
            }
        }
        return true;
    }
}