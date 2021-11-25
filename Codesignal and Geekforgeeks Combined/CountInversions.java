Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 

Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).
Example 2:

Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already 
sorted so there is no inversion count.
Example 3:

Input: N = 3, arr[] = {10, 10, 10}
Output: 0
Explanation: As all the elements of array 
are same, so there is no inversion count.
Your Task:
You don't need to read input or print anything. Your task is to complete the function inversionCount() which takes the array arr[] and the size of the array as inputs and returns the inversion count of the given array.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 5*105
1 ≤ arr[i] ≤ 1018



//User function Template for Java

// https://youtu.be/kQ1mJlwW-c0 reference

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long n)
    {
        // Your Code Here
        if (n == 0 || arr == null) {
            return 0;
        }
        long [] temp = new long [(int)n];
        return mergeSort(arr, temp, 0, n - 1);
    }
    
    static long mergeSort(long [] arr, long [] temp, long left, long right) {
        long count = 0;
        if (left < right) {
            long middle = left + (right - left) / 2;
            count += mergeSort(arr, temp, left, middle);
            count += mergeSort(arr, temp, middle + 1, right);
            count += merge(arr, temp, left, middle + 1, right);
        }
        return count;
    }
    
    static long merge(long [] arr, long [] temp, long left, long middle, long right) {
        long count = 0;
        long i = left;
        long j = middle;
        long k = left;
        while (i < middle && j <= right) {
            if (arr[(int)i] <= arr[(int)j]) {
                temp[(int)k++] = arr[(int)i++];
            }
            else {
                temp[(int)k++] = arr[(int)j++];
                count += (middle - i);
            }
        }
        while (i < middle) {
            temp[(int)k++] = arr[(int)i++];
        }
        while (j <= right) {
            temp[(int)k++] = arr[(int)j++];
        }
        for (long p=left; p<= right; p++) {
            arr[(int)p] = temp[(int)p];
        }
        return count;
    }
}