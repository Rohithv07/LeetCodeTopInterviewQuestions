Given an unsorted array A of size N that contains only non-negative integers, find a continuous sub-array which adds to a given number S.

 

Example 1:

Input:
N = 5, S = 12
A[] = {1,2,3,7,5}
Output: 2 4
Explanation: The sum of elements 
from 2nd position to 4th position 
is 12.
 

Example 2:

Input:
N = 10, S = 15
A[] = {1,2,3,4,5,6,7,8,9,10}
Output: 1 5
Explanation: The sum of elements 
from 1st position to 5th position
is 15.
 

Your Task:
You don't need to read input or print anything. The task is to complete the function subarraySum() which takes arr, N and S as input parameters and returns a list containing the starting and ending positions of the first such occurring subarray from the left where sum equals to S. The two indexes in the list should be according to 1-based indexing. If no such subarray is found, return an array consisting only one element that is -1.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 105
1 <= Ai <= 1010



class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        if (arr == null || n == 0)
            return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        int currentSum = 0;
        for (int end = 0; end < n; end++) {
            currentSum += arr[end];
            if (currentSum < s) {
                continue;
            }
            else if (currentSum > s) {
                while (currentSum > s) {
                    currentSum -= arr[start];
                    start++;
                }
                if (currentSum == s) {
                    result.add(start + 1);
                    result.add(end + 1);
                    return result;
                }
            }
            else {
                result.add(start + 1);
                result.add(end + 1);
                break;
            }
        }
        if (result.size() == 0)
            result.add(-1);
        return result;
    }
}
