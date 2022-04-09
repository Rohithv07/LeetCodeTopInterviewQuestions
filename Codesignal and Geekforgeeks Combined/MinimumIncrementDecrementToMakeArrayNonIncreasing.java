Given an array a of length n, find the minimum number of operations required to make it non-increasing. You can select any one of the following operations and preform it any number of times on an array element.

increment the array element by 1.
decrement the array element by 1. 
Example 1:

Input:
N = 4 
array = {3, 1, 2, 1}
Output: 1
Explanation: 
Decrement array[2] by 1. 
New array becomes {3,1,1,1} which is non-increasing. 
Therefore, only 1 step is required. 

Example 2:

Input:
N = 4 
array = {3, 1, 5, 1}
Output: 4

Your Task:
You don't need to read input or print anything. Complete the function minOperations() that takes n and array a as input parameters and returns the minimum number of operations required. 

Expected time complexity: O(nlogn)
Expected space complexity: O(n)


Constraints:
1 <= n <= 10^4
1 <= a[i] <= 10^4


class Solution 
{ 
	public static int minOperations(int a[], int n) 
	{ 
	    // code here 
	    int minOperation = 0;
	    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	    for (int i = 0; i < n; i++) {
	        if (!minHeap.isEmpty() && minHeap.peek() < a[i]) {
	            minOperation += a[i] - minHeap.poll();
	            minHeap.offer(a[i]);
	        }
	        minHeap.offer(a[i]);
	    }
	    return minOperation;
	} 
} 