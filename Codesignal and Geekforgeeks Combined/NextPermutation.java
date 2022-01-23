Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater permutation of list of numbers. If such arrangement is not possible, it must be rearranged to the lowest possible order i.e. sorted in an ascending order. You are given an list of numbers arr[ ] of size N.

Example 1:

Input: N = 6
arr = {1, 2, 3, 6, 5, 4}
Output: {1, 2, 4, 3, 5, 6}
Explaination: The next permutation of the 
given array is {1, 2, 4, 3, 5, 6}.
Example 2:

Input: N = 3
arr = {3, 2, 1}
Output: {1, 2, 3}
Explaination: As arr[] is the last 
permutation. So, the next permutation 
is the lowest one.
Your Task:
You do not need to read input or print anything. Your task is to complete the function nextPermutation() which takes N and arr[ ] as input parameters and returns a list of numbers containing the next permutation.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 10000


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int n, int arr[]){
        int decreasingIndex = -1;
        int decreasingNumber = 0;
        for (int i=n-2; i>=0; i--) {
            if (arr[i] < arr[i + 1]) {
                decreasingIndex = i;
                decreasingNumber = arr[i];
                break;
            }
        }
        if (decreasingIndex == -1) {
            reverse(arr, 0, n - 1);
            return converter(arr);
        }
        int nextIncreasingIndex = decreasingIndex + 1;
        int nextIncreasingNumber = arr[decreasingIndex + 1];
        for (int i=nextIncreasingIndex; i<n; i++) {
            if (arr[i] > decreasingNumber) {
                if (arr[i] < nextIncreasingNumber) {
                    nextIncreasingNumber = arr[i];
                    nextIncreasingIndex = i;
                }
            }
        }
        swap(arr, decreasingIndex, nextIncreasingIndex);
        reverse(arr, decreasingIndex + 1, n - 1);
        return converter(arr);
    }
    
    static List<Integer> converter(int [] arr) {
        List<Integer> result = new ArrayList<>();
        for (int number : arr) {
            result.add(number);
        }
        return result;
    }
    
    static void reverse(int [] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    
    static void swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}