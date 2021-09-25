Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.
Your Task:
You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
-1000 <= A[i] <= 1000, for each valid i



// same as finding contiguos array with maximum number of consecutive 0s and 1s
class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        if (n == 0 || arr == null) {
            return 0;
        }
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> runningSumWithIndex = new HashMap<>();
        runningSumWithIndex.put(0, -1); // some default value
        for (int i=0; i<n; i++) {
            sum += arr[i];
            if (runningSumWithIndex.containsKey(sum)) {
                result = Math.max(result, i - runningSumWithIndex.get(sum));
            }
            else {
                runningSumWithIndex.put(sum, i);
            }
        }
        return result;
    }
}