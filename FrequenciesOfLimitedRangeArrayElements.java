Given an array A[] of N positive integers which can contain integers from 1 to P where elements can be repeated or can be absent from the array. Your task is to count the frequency of all elements from 1 to N.


Example 1:

Input:
N = 5
arr[] = {2, 3, 2, 3, 5}
P = 5
Output:
0 2 2 0 1
Explanation: 
Counting frequencies of each array element
We have:
1 occurring 0 times.
2 occurring 2 times.
3 occurring 2 times.
4 occurring 0 times.
5 occurring 1 time.
Example 2:

Input:
N = 4
arr[] = {3,3,3,3}
P = 3
Output:
0 0 4 0
Explanation: 
Counting frequencies of each array element
We have:
1 occurring 0 times.
2 occurring 0 times.
3 occurring 4 times.
4 occurring 0 times.

Your Task:
Complete the function frequencycount() that takes the array and n as input parameters and modify the array in place to denote the frequency count of each element from 1 to N. i,e element at index 0 should represent the frequency of 1 and so on.


Note: Can you solve this problem without using extra space (O(1) Space) !


Constraints:
1 ≤ N ≤ 105
1 ≤ P ≤ 4*104 
1 <= A[i] <= P


class Solution{
    //Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int n, int p)
    {
        // code here
        for (int i=0; i<n; i++) {
            arr[i] -= 1;
        }
        Arrays.sort(arr);
        int index = n;
        for (int i=0; i<n; i++) {
            if (arr[i] >= n) {
                arr[i] = 0;
                if (index == n) {
                    index = i;
                }
            }
        }
        for (int i=0; i<index; i++) {
            arr[arr[i] % n] += n;
        }
        for (int i=0; i<n; i++) {
            arr[i] /= n;
        }
    }
}
