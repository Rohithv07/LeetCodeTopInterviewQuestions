You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e. 0 <= i < n).

In one operation, you can select two indices x and y where 0 <= x, y < n and subtract 1 from arr[x] and add 1 to arr[y] (i.e. perform arr[x] -=1 and arr[y] += 1). The goal is to make all the elements of the array equal. It is guaranteed that all the elements of the array can be made equal using some operations.

Given an integer n, the length of the array. Return the minimum number of operations needed to make all the elements of arr equal.

 

Example 1:

Input: n = 3
Output: 2
Explanation: arr = [1, 3, 5]
First operation choose x = 2 and y = 0, this leads arr to be [2, 3, 4]
In the second operation choose x = 2 and y = 0 again, thus arr = [3, 3, 3].
Example 2:

Input: n = 6
Output: 9
 

Constraints:

1 <= n <= 10^4


class Solution {
    public int minOperations(int n) {
        if (n == 1)
            return 0;
        int operations = 0;
        int [] nums = buildArray(n);
        int targetSum = findSum(nums) / n;
        int left = 0;
        int right = n - 1;
        int middle = (left + right) / 2;
        while (left <= middle) {
            int currentNumber = nums[left];
            operations += targetSum - currentNumber;
            left += 1;
        }
        return operations;
    }
    
    public int [] buildArray(int n) {
        int [] result = new int [n];
        for (int i=0; i<n; i++) {
            result[i] = (2 * i) + 1;
        }
        return result;
    }
    
    public int findSum(int [] nums) {
        int total = 0;
        for (int number : nums) {
            total += number;
        }
        return total;
    }
}


// 1 liner
// Refer: https://leetcode.com/problems/minimum-operations-to-make-array-equal/discuss/794163/Java-2-Lines
class Solution {
    public int minOperations(int n) {
        return n * n / 4;
    }
}
