Given an array arr[] of N positive integers. Find an integer denoting the maximum XOR subset value in the given array arr[].

Example 1:

Input : 
N = 3
arr[] = {2, 4, 5}
Output : 7
Explanation : 
The subset {2, 5} has maximum 
subset XOR value.
Example 2 :

Input : 
N= 3
arr[] = {9, 8, 5}
Output : 13
Explanation : 
The subset {8, 5} has maximum 
subset XOR value.
Your Task :
You don't need to read input or print anything. Your task is to complete the function maxSubarrayXOR() which takes the array and an integer as input and returns the maximum subset XOR value.
 
Expected Time Complexity : O(N*Log(max(arr[i])))
Expected Auxiliary Space : O(1)
 
Contraints :
1 <= N <= 105
1 <= arr[i] <= 106


class Solution
{
    public static int maxSubarrayXOR(int nums[], int n)
    {
        //add code here.
        int index = 0;
        for (int i=31; i>=0; i--) {
            int maxIndex = index;
            int maxElement = Integer.MIN_VALUE;
            for (int j=index; j<n; j++) {
                if ((nums[j] & (1 << i)) != 0 && nums[j] > maxElement) {
                    maxElement = nums[j];
                    maxIndex = j;
                }
            }
            if (maxElement == Integer.MIN_VALUE) {
                continue;
            }
            int temp = nums[index];
            nums[index] = nums[maxIndex];
            nums[maxIndex] = temp;
            maxIndex = index;
            for (int j=0; j<n; j++) {
                if (j != maxIndex && (nums[j] & (1 << i)) != 0) {
                    nums[j] ^= nums[maxIndex];
                }
            }
            index += 1;
        }
        int result = 0;
        for (int i=0; i<n; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
