Given an array arr[] of size N containing equal number of odd and even numbers. Arrange the numbers in such a way that all the even numbers get the even index and odd numbers get the odd index.
Note: There are multiple possible solutions, Print any one of them. Also, 0-based indexing is considered.

 

Example 1:

Input:
N = 6
arr[] = {3, 6, 12, 1, 5, 8}
Output:
1
Explanation:
6 3 12 1 8 5 is a possible solution.
The output will always be 1 if your
rearrangement is correct.
Example 2:
Input:
N = 4
arr[] = {1, 2, 3, 4}
Output :
1

Your Task:  
You don't need to read input or print anything. Your task is to complete the function reArrange() which takes an integer N and an array arr of size N as input and reArranges the array in Place without any extra space.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ arr[i] ≤ 105




class Solution {
    static void reArrange(int[] arr, int n) {
        // code here
        int i = 0;
        int j = 1;
        while (i < n && j < n) {
            if (arr[i] % 2 == 0) {
                i += 2;
            }
            else if (arr[j] % 2 == 1) {
                j += 2;
            }
            else {
                swap(arr, i, j);
                i += 2;
                j += 2;
            }
        }
    }
    
    static void swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}