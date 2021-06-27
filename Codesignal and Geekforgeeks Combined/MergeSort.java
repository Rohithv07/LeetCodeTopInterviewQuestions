Given an array arr[], its starting position l and its ending position r. Sort the array using merge sort algorithm.
Example 1:

Input:
N = 5
arr[] = {4 1 3 9 7}
Output:
1 3 4 7 9
Example 2:

Input:
N = 10
arr[] = {10 9 8 7 6 5 4 3 2 1}
Output:
1 2 3 4 5 6 7 8 9 10

Your Task:
You don't need to take the input or print anything. Your task is to complete the function merge() which takes arr[], l, m, r as its input parameters and modifies arr[] in-place such that it is sorted from position l to position r, and function mergeSort() which uses merge() to sort the array in ascending order using merge sort algorithm.

Expected Time Complexity: O(nlogn) 
Expected Auxiliary Space: O(n)

Constraints:
1 <= N <= 105
1 <= arr[i] <= 103



class Solution
{
    void merge(int arr[], int left, int middle, int right)
    {
         // Your code here
         int leftSubLength = middle - left + 1;
         int rightSubLength = right - middle;
         int [] leftPart = new int [leftSubLength];
         int [] rightPart = new int [rightSubLength];
         for (int i=0; i<leftSubLength; i++) {
             leftPart[i] = arr[i + left];
         }
         for (int i=0; i<rightSubLength; i++) {
             rightPart[i] = arr[i + middle + 1];
         }
         int i = 0;
         int j = 0;
         int k = left;
         while (i < leftSubLength && j < rightSubLength) {
             if (leftPart[i] <= rightPart[j]) {
                 arr[k] = leftPart[i];
                 i++;
             }
             else {
                 arr[k] = rightPart[j];
                 j++;
             }
             k++;
         }
         while (i < leftSubLength) {
             arr[k] = leftPart[i];
             i++;
             k++;
         }
         while (j < rightSubLength) {
             arr[k] = rightPart[j];
             j++;
             k++;
         }
    }
    void mergeSort(int arr[], int left, int right)
    {
        //code here
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }
}

