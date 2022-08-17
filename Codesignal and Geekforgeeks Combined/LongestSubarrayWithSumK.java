Given an array containing N integers and an integer K., Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.

 

Example 1:
 

Input :
A[] = {10, 5, 2, 7, 1, 9}
K = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.
Example 2:

Input : 
A[] = {-1, 2, 3}
K = 6
Output : 0
Explanation: 
There is no such sub-array with sum 6.
Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function smallestSubsegment() that takes an array (A), sizeOfArray (n),  sum (K)and returns the required length of the longest Sub-Array. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

 

Constraints:
1<=N<=105
-105<=A[i], K<=105



//User function Template for Java

class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int a[], int n, int k) {
        //Complete the function
        Map<Long, Integer> map = new HashMap<>();
        int longestSubarray = 0;
        long prefixSum = 0;
        map.put(0l, -1);
        for (int i = 0; i < n; i++) {
            prefixSum += a[i];
            // this condition is added as there can be negative numbers also
            if (prefixSum == k) {
                longestSubarray = i;
            }
            if (map.containsKey(prefixSum - k)) {
                longestSubarray = Math.max(longestSubarray, i - map.get(prefixSum - k));
            }
            // only update the map, if the prefix sum is not already in map.
            // this has to be taken care when there are negative numbers
            if (!map.containsKey(prefixSum))
                map.put(prefixSum, i);
        }
        return longestSubarray;
    }
    
    
}


