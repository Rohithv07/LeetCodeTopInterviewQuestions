Given an array A[] of N integers and a range(L, R). The task is to find the number of subarrays having sum in the range L to R (inclusive).

Example 1:

Input:
N = 3, L = 3, R = 8
A[] = {1, 4, 6}
Output: 
3
Explanation: 
The subarrays are [1,4], [4] and [6]
Example 2:

Input:
N = 4, L = 4, R = 13
A[] = {2, 3, 5, 8}
Output: 
6
Explanation: 
The subarrays are [2,3], [2,3,5], 
[3,5],[5], [5,8] and [8]
Your Task: 
You don't need to read input or print anything. Complete the function countSubarray( ) which takes the integer N , the array A[], the integer L and the integer R as input parameters and returns the number of subarays. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 106
1 ≤ A[] ≤ 109
1 ≤ L ≤ R ≤ 1015


//User function Template for Java
class Solution 
{ 
    long countSubarray(int n,int a[],long l,long r) {
        // code here
        if (n == 0 || a == null) {
            return 0;
        }
        // 1.find number of subarray with sum < r
        // 2.find number of subarray with sum < l-1
        // subtract 1 - 2 equation
        
        long lessThanR = countSubArray(a, n, r);
        long lessThanLMinusOne = countSubArray(a, n, l - 1);
        return lessThanR - lessThanLMinusOne;
    }
    
    long countSubArray(int [] a, int n, long limit) {
        long sum = 0;
        long count = 0;
        int start = 0;
        for (int end=0; end<n; end++) {
            sum += a[end];
            while (sum > limit && start <= end) {
                sum -= a[start];
                start++;
            }
            count += end - start + 1;
        }
        return count;
    }
} 