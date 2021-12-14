Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.

 

Example 1:

Input : 
N = 5
A[] = {-8, 2, 3, -6, 10}
K = 2
Output : 
-8 0 -6 -6
Explanation :
First negative integer for each window of size k
{-8, 2} = -8
{2, 3} = 0 (does not contain a negative integer)
{3, -6} = -6
{-6, 10} = -6
 
Example 2:
Input : 
N = 8
A[] = {12, -1, -7, 8, -15, 30, 16, 28}
K = 3
Output :
-1 -1 -7 -15 -15 0 
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function printFirstNegativeInteger() which takes the array A[], its size N and an integer K as inputs and returns the first negative number in every window of size K starting from the first till the end. If a window does not contain a negative integer , then return 0 for that window.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(K)

Constraints:
1 <= N <= 105
1 <= A[i] <= 105
1 <= K <= N




class Compute {
    
    public long[] printFirstNegativeInteger(long a[], int n, int k)
    {
        if (a == null || n == 0 || k <= 0) {
            return new long []{};
        }
        long [] result = new long[n - k + 1];
        Queue<Long> queue = new LinkedList<>();
        // compute for the very first window
        for (int i=0; i<k; i++) {
            if (a[i] < 0) {
                queue.offer(a[i]);
            }
        }
        if (queue.size() == 0) {
            result[0] = 0;
        }
        else {
            result[0] = queue.peek();
        }
        int index = 1;
        int j = 0;
        // now check for the next window and if its the size of window, pop from front of queue
        for (int i=k; i<n; i++) {
            if (!queue.isEmpty() && queue.peek() == a[j]) {
                queue.poll();
            }
            j++;
            if (a[i] < 0) {
                queue.offer(a[i]);
            }
            if (queue.size() == 0) {
                result[index++] = 0;
            }
            else {
                result[index++] = queue.peek();
            }
        }
        return result;
    }
}