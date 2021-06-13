Given an array arr[] of size N. For every element in the array, the task is to find the index of the farthest element in the array to the right which is smaller than the current element. If no such number exists then print -1. 

Examples: 

Input: arr[] = {3, 1, 5, 2, 4} 
Output: 3 -1 4 -1 -1 
arr[3] is the farthest smallest element to the right of arr[0]. 
arr[4] is the farthest smallest element to the right of arr[2]. 
And for the rest of the elements, there is no smaller element to their right.
Input: arr[] = {1, 2, 3, 4, 0} 
Output: 4 4 4 4 -1 


class Solution 
{ 
    static int[] farNumber(int n, int arr[])
	{    
	    if (n == 1)
	        return new int [] {-1};
	    int [] temporarySuffixArray = new int [n];
	    temporarySuffixArray[n - 1] = arr[n - 1];
	    int i = n - 2;
	    while (i >= 0) {
	        temporarySuffixArray[i] = Math.min(arr[i], temporarySuffixArray[i + 1]);
	        i -= 1;
	    }
	   // for (int number : temporaryArray) {
	   //     System.out.print(number + " ");
	   // }
	   int [] result = new int [n];
	   for (i=0; i<n; i++) {
	       binarySearch(temporarySuffixArray, result, i+1, n-1, -1, arr, i);
	   }
	    return result;
	}
	
	static void binarySearch(int [] suffix, int [] result, int low, int high, int answer, int [] arr, int index) {
	    while (low <= high) {
	        int middle = low + (high - low) / 2;
	        if (suffix[middle] < arr[index]) {
	            System.out.println(answer);
	            answer = middle;
	            low = middle + 1;
	        }
	        else {
	            high = middle - 1;
	        }
	    }
	    result[index] = answer;
	}
} 
