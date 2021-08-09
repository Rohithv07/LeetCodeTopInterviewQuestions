Given an array arr[] containing N integers. In one step, any element of the array can either be increased or decreased by one. Find minimum steps required such that the product of the array elements becomes 1.

 

Example 1:

Input:
N = 3
arr[] = {-2, 4, 0}
Output:
5
Explanation:
We can change -2 to -1, 0 to -1 and 4 to 1.
So, a total of 5 steps are required
to update the elements such that
the product of the final array is 1. 
Example 2:
Input:
N = 3
arr[] = {-1, 1, -1} 
Output :
0
Explanation:
Product of the array is already 1.
So, we don't need to change anything.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function makeProductOne() which takes an integer N and an array arr of size N as input and returns the minimum steps required.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
-103 ≤ arr[i] ≤ 103


class Solution {
    static int makeProductOne(int[] arr, int n) {
        // code here
        if (arr == null || n == 0)
            return 0;
        int negative = 0;
        int zero = 0;
        int total = 0;
        for (int i=0; i<n; i++) {
            if (arr[i] > 0 && arr[i] != 1) {
                total += arr[i] - 1;
            }
            else if (arr[i] == 0) {
                total += 1;
                zero += 1;
            }
            else if (arr[i] < 0) {
                total += Math.abs(arr[i]);
                negative += 1;
            }
        }
        total -= negative;
        if (negative % 2 != 0 && zero == 0) {
            total += 2;
        }
        return total;
    }
}