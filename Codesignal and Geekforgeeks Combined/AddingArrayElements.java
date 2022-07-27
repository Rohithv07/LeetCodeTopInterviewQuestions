Given an array Arr[] of size N and an integer K, you have to add the first two minimum elements of the array until all the elements are greater than or equal to K and find the number of such operations required.

Example 1:

Input:
N = 6, K = 6 
Arr[] = {1, 10, 12, 9, 2, 3}
Output: 2
Explanation: First we add (1 + 2), now the
new list becomes 3 10 12 9 3, then we add
(3 + 3), now the new list becomes 6 10 12 9,
Now all the elements in the list are greater
than 6. Hence the output is 2 i:e 2 operations
are required to do this. 
Example 2:

Input:
N = 4, K = 4
Arr[] = {5, 4, 6, 4}
Output: 0
Explanation: Every element in the given array 
is greater than or equal to K.
Your Task:
You don't need to read input or print anything. Your task is to complete the function minOperations() which takes array of integers arr, n and k as parameters and returns an integer denoting the answer. If it is not possible to make elements greater than or equal to K, return -1.

Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(N)

Constraints :
1 ≤ N, K ≤ 105
1 ≤ Arr[i] ≤ 106


class Solution {
    int minOperations(int[] arr, int n, int k) {
        // code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            minHeap.offer(arr[i]);
        }
        while (minHeap.size() >= 2) {
            int min1 = minHeap.poll();
            int min2 = minHeap.poll();
            if (min1 >= k) {
                return count;
            }
            count++;
            int sum = min1 + min2;
            minHeap.offer(sum);
        }
        return count;
    }
}
