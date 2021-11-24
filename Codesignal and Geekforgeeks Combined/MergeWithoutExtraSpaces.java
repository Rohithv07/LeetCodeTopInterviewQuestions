Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order without using any extra space. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.
 

Example 1:

Input: 
n = 4, arr1[] = [1 3 5 7] 
m = 5, arr2[] = [0 2 6 8 9]
Output: 
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]
Explanation:
After merging the two 
non-decreasing arrays, we get, 
0 1 2 3 5 6 7 8 9.
Example 2:

Input: 
n = 2, arr1[] = [10, 12] 
m = 3, arr2[] = [5 18 20]
Output: 
arr1[] = [5 10]
arr2[] = [12 18 20]
Explanation:
After merging two sorted arrays 
we get 5 10 12 18 20.


Your Task:
You don't need to read input or print anything. You only need to complete the function merge() that takes arr1, arr2, n and m as input parameters and modifies them in-place so that they look like the sorted merged array when concatenated.
 

Expected Time Complexity:  O((n+m) log(n+m))
Expected Auxilliary Space: O(1)
 

Constraints:
1 <= n, m <= 5*104
0 <= arr1i, arr2i <= 107

// most direct approach with extra space

class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here 
        if (arr1 == null || n == 0 || arr2 == null || m == 0) {
            return;
        }
        long [] storing = new long [n + m];
        int index = 0;
        for (long number : arr1) {
            storing[index++] = number;
        }
        for (long number : arr2) {
            storing[index++] = number;
        }
        Arrays.sort(storing);
        index = 0;
        for (int i=0; i<n; i++) {
            arr1[i] = storing[index++];
        }
        for (int j=0; j<m; j++) {
            arr2[j] = storing[index++];
        }
    }
}


// another approach without extra space but TC O(N * M). Might be TLE

class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here 
        if (arr1 == null || n == 0 || arr2 == null || m == 0) {
            return;
        }
        for (int i=0; i<n; i++) {
            if (arr1[i] > arr2[0]) {
                long temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
            }
            // now we need to do internal sorting on array 2
            long firstElement = arr2[0];
            int k = 0;
            for (k=1; k<m && arr2[k] < firstElement; k++) {
                arr2[k - 1] = arr2[k];
            }
            arr2[k - 1] = firstElement;
        }
    }
}





//User function Template for Java
// https://youtu.be/hVl2b3bLzBw
class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here 
        int gap = findGap(n + m);
        int i;
        int j;
        long temp;
        while (gap > 0) {
            for (i=0; i+gap<n; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
            }
            for (j=gap > n ? gap - n : 0; j < m && i < n; i++, j++) {
                if (arr1[i] > arr2[j]) {
                    temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
            if (j < m) {
                for (j=0; j+gap<m; j++) {
                    if (arr2[j] > arr2[j + gap]) {
                        temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
                }
            }
            gap = findGap(gap);
        }
    }
    
    private static int findGap(int range) {
        if (range <= 1)
            return 0;
        return (range / 2) + (range % 2); // ceil
    }
}
