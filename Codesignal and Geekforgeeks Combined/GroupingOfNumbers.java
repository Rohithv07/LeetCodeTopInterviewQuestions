One day Jim came across array arr[] of N numbers. He decided to divide these N numbers into different groups. Each group contains numbers in which sum of any two numbers should not be divisible by an integer K. Print the size of the group containing maximum numbers.

 

Example 1:

Input:
N = 4, K = 8
arr[] = {1, 7, 2, 6}
Output:
2
Explanation:
The  group of numbers which can be formed
are: (1),(2),(7),(6),(1,2),(1,6),(7,2),(7,6).
So,the maximum possible size of the group is 2.
Example 2:

Input:
N = 2, K = 3
arr[] = {1, 2}
Output:
1
Explanation:
The  group of numbers which can be formed
are: (1),(2). So,the maximum possible size
of the group is 1.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxGroupSize() which takes 2 Integers N, and K and also an array arr[] of N integers as input and returns the maximum group size possible.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(K)

 

Constraints:
1 ≤ N,K,arr[i] ≤ 105


class Solution {
    static int maxGroupSize(int[] arr, int n, int k) {
        // code here
        int [] remainder = new int [k];
        for (int num : arr) {
            remainder[num % k] += 1;
        }
        int size = 0;
        int i = 1;
        int j = k - 1;
        while (i < j) {
            size += Math.max(remainder[i], remainder[j]);
            i++;
            j--;
        }
        if (remainder[0] != 0) {
            size++;
        }
        if ((k % 2) == 0 && (remainder[k / 2] >= 1)) {
            size++;
        }
        return size;
    }
}