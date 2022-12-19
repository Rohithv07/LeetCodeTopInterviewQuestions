Given an unsorted array arr[ ] of size n, you need to find the maximum difference of absolute values of elements and indexes, i.e., for i <= j, calculate maximum of | arr[ i ] - arr[ j ] | + | i - j |. 

Example 1:

Input : 
n = 3
arr[ ] = {1, 3, -1}
Output: 5
Explanation:
Maximum difference comes from indexes 
1, 2 i.e | 3 - (-1) | + | 1 - 2 | = 5

Example 2:

Input : 
n = 4
arr[ ] = {5, 9, 2, 6} 
Output:  8
Explanation: 
Maximum difference comes from indexes 
1, 2 i.e | 9 - 2 | + | 1 - 2 | = 8
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function maxDistance() that takes an array (arr), sizeOfArray (n), and return the maximum difference as given in the question.  The driver code takes care of the printing.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).
 

Constraints:
1 <= n <= 5*(10^5)
-10^6 <= arr[ i ] <= 10^6

class Solution{
    
   
    // Function for finding maximum and value pair
    public static int maxDistance (int arr[], int n) {
        //Complete the function
        if (n == 0 || arr == null) {
            return 0;
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            max1 = Math.max(max1, num + i);
            max2 = Math.max(max2, -num + i);
            min1 = Math.min(min1, num + i);
            min2 = Math.min(min2, -num + i);
        }
        return Math.max(max1 - min1, max2 - min2);
    }
    
    
}
