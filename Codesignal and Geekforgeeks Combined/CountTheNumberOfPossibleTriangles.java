Given an unsorted array arr[] of n positive integers. Find the number of triangles that can be formed with three different array elements as lengths of three sides of triangles. 

Example 1:

Input: 
n = 3
arr[] = {3, 5, 4}
Output: 
1
Explanation: 
A triangle is possible 
with all the elements 5, 3 and 4.
Example 2:

Input: 
n = 5
arr[] = {6, 4, 9, 7, 8}
Output: 
10
Explanation: 
There are 10 triangles
possible  with the given elements like
(6,4,9), (6,7,8),...
 

Your Task: 
This is a function problem. You only need to complete the function findNumberOfTriangles() that takes arr[] and n as input parameters and returns the count of total possible triangles.

Expected Time Complexity: O(n2).
Expected Space Complexity: O(1).

Constraints:
3 <= n <= 103
1 <= arr[i] <= 103


class Solution
{
    //Function to count the number of possible triangles.
    static int findNumberOfTriangles(int arr[], int n)
    {
        // code here
        if (n < 3)
        return 0;
        int count = 0;
        Arrays.sort(arr);
        for (int i=0; i<n-2; i++) {
            int k = i + 2;
            for (int j=i+1; j<n; j++) {
                /* Find the rightmost element which is smaller
                than the sum of two fixed elements
                The important thing to note here is, we use
                the previous value of k. If value of arr[i] +
                arr[j-1] was greater than arr[k], then arr[i] +
                arr[j] must be greater than k, because the
                array is sorted. */
                while (k < n && arr[i] + arr[j] > arr[k])
                    k++;
                if (k > j)
                    count += k - j - 1;
            }
        }
        return count;
    }
}
