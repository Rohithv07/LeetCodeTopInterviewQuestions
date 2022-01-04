Given a binary array A[] of size N. The task is to arrange the array in increasing order.

Note: The binary array contains only 0  and 1.

Example 1:

Input:
N = 5
A[] = {1,0,1,1,0}
Output: 0 0 1 1 1
Example 2:

Input:
N = 10
A[] = {1,0,1,1,1,1,1,0,0,0}
Output: 0 0 0 0 1 1 1 1 1 1
Your Task:
Complete the function SortBinaryArray() which takes given array as input and returns the sorted array. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Challenge: Try doing it in one pass.

Constraints:
1 <= N <= 106
0 <= A[i] <= 1

class Solution 
{ 
	static int[] SortBinaryArray(int arr[], int n) 
	{ 
	    // code here
	    if (arr == null || n == 0) {
	        return new int []{};
	    }
	    int left = 0;
	    int right = n - 1;
	    int index = 0;
	    while (left < right && index <= right) {
	        if (arr[index] == 0) {
	            arr[index] = arr[left];
	            arr[left] = 0;
	            left++;
	        }
	        index++;
	    }
	    return arr;
	} 
} 



class Solution
{
    //Function to sort the binary array.
    static void binSort(int a[], int n)
    {
        // add your code here
        
        
        /**************
        * No need to print the array
        * ************/
        int movingPointer = 0;
        int trackZero = 0;
        while (movingPointer < n) {
            if (a[movingPointer] == 0) {
                swap(a, trackZero, movingPointer);
                trackZero++;
            }
            movingPointer++;
        }
    }
    
    static void swap(int [] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

class Solution
{
    //Function to sort the binary array.
    static void binSort(int A[], int N)
    {
        // add your code here
        
        
        /**************
        * No need to print the array
        * ************/
        int i = 0;
        int j = N - 1;
        while (i < j) {
            if (A[i] == 1 && A[j] == 0) {
                swap(A, i, j);
                i++;
                j--;
            }
            if (A[i] == 0) {
                i++;
            }
            if (A[j] == 1) {
                j--;
            }
        }
    }
    
    private static void swap(int [] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}


