Given an array arr[] consisting of n integers, find the length of the longest subarray with positive (non zero) product.

 

Example 1:

Input:
arr[] ={0, 1, -2, -3, -4} 
Output:
3
Explanation: 
The longest subarray with positive product is: 
{1, -2, -3}.Therefore, the required length is 3.
 

Example 2:

Input:
arr[]={-1, -2, 0, 1, 2}
Output:
2
Explanation:
The longest subarray with positive products 
are: {-1, -2}, {1, 2}. Therefore, the required 
length is 2.
 

Your Task: This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function maxLength() that takes array arr[], and an integer n as parameters and return the length of the longest subarray where the product of all of its element is positive. 

 

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

 

Constraints:
 1<=n<=105
-109<=arr[i]<=109


class Solution{
    /* Function to return the length of the
       longest subarray with ppositive product */
    int maxLength(int arr[], int n) { 
        //code here
        if (n == 1 && arr[0] > 0) {
            return 1;
        }
        int zeroFound = -1;
        int negativeFound = -1;
        int zeroCount = 0;
        int negativeCount = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (num == 0) {
                zeroFound = i;
                zeroCount++;
                negativeFound = -1;
                negativeCount = 0;
            }
            else if (num < 0) {
                negativeFound = negativeFound == -1 ? i : negativeFound;
                negativeCount++;
            }
            if (negativeCount % 2 == 0) {
                max = Math.max(max, i - zeroFound);
            }
            else {
                max = Math.max(max, i - negativeFound);
            }
        }
        return max;
    }
   
}