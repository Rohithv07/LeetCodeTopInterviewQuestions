Given an array arr[] of N integers arranged in a circular fashion. Your task is to find the maximum contiguous subarray sum.


Example 1:

Input:
N = 7
arr[] = {8,-8,9,-9,10,-11,12}
Output:
22
Explanation:
Starting from the last element
of the array, i.e, 12, and 
moving in a circular fashion, we 
have max subarray as 12, 8, -8, 9, 
-9, 10, which gives maximum sum 
as 22.
Example 2:

Input:
N = 8
arr[] = {10,-3,-4,7,6,5,-4,-1}
Output:
23
Explanation: Sum of the circular 
subarray with maximum sum is 23

Your Task:
The task is to complete the function circularSubarraySum() which returns a sum of the circular subarray with maximum sum.


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).


Constraints:
1 <= N <= 106
-106 <= Arr[i] <= 106


/*
The trick here is that to find the minimum subarray sum, we invert the sign of all the numbers in original subarray, and find the maximum subarray sum using Kadane algorithm. Then add it with the total sum. (which is similar to
[total - minimum subarray sum ])
*/
class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        
        // Your code here
        return Integer.max(kadane(a,n), reverseKadane(a,n));
    }
    
    static int kadane(int [] a, int n) {
        int max = a[0];
        int currentMax = max;
        for (int i=1; i<n; i++) {
            currentMax = Math.max(a[i], currentMax + a[i]);
            max = Math.max(max, currentMax);
        }
        return max;
    }
    
    static int reverseKadane(int [] nums, int length) {
        int totalSum = 0;
        int currentNonCircularSum = kadane(nums, length);
        int [] reversedSignNums = new int [length];
        for (int i=0; i<length; i++) {
            totalSum += nums[i];
            reversedSignNums[i] = -nums[i];
        }
        int circular = totalSum + kadane(reversedSignNums, length); //(equivalent as total - minsubarraysum)
        return circular == 0 ? currentNonCircularSum : circular;
    }
    
}


