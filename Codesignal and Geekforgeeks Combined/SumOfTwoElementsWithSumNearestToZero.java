Given an array of n integers

Example 1:

Input:
N = 3
arr[] = {-8 -66 -60}
Output: -68
Explanation: Sum of two elements closest to 
zero is -68 using numbers -60 and -8.
â€‹Example 2:

Input: 
N = 6
arr[] = {-21 -67 -37 -18 4 -65}
Output: -14
Explanation: Sum of two elements closest to
zero is -14 using numbers -18 and 4.

Your Task:
You don't need to read input or print anything. You just need to complete the function closestToZero() which takes an array arr[] and its size n as inputs and returns the maximum sum closest to zero that can be formed by summing any two elements in the array.


Expected Time Complexity: O(N*logN).
Expected Auxiliary Space: O(1).


Constraints:
1 ≤ N ≤ 5 * 105
-106 ≤ arr[i] ≤ 106


class Sol
{
    public static int closestToZero (int arr[], int n)
    {
        // your code here
        if (arr == null || n == 0) {
            return 0;
        }
        int nearestSum = Integer.MAX_VALUE;
        Arrays.sort(arr);
        if (arr[0] >= 0 && n > 1) {
            return arr[0] + arr[1];
        }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (Math.abs(nearestSum) > Math.abs(currentSum)) {
                nearestSum = currentSum;
            }
            if (Math.abs(nearestSum) == Math.abs(currentSum)) {
                nearestSum = Math.max(nearestSum, currentSum);
            }
            if (currentSum < 0) {
                left++;
            }
            else {
                right--;
            }
        }
        return nearestSum;
    }
}