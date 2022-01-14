Given two binary max heaps as arrays, merge the given heaps to form a new max heap.

 

Example 1:

Input  : 
n = 4 m = 3
a[] = {10, 5, 6, 2}, 
b[] = {12, 7, 9}
Output : 
{12, 10, 9, 2, 5, 7, 6}
Explanation :




 

 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function mergeHeaps() which takes the array a[], b[], its size n and m, as inputs and return the merged max heap. Since there can be multiple solutions, therefore, to check for the correctness of your solution, your answer will be checked by the driver code and will return 1 if it is correct, else it returns 0.

 

Expected Time Complexity: O(n.Logn)
Expected Auxiliary Space: O(n + m)

 

Constraints:
1 <= n, m <= 105
1 <= a[i], b[i] <= 2*105


// using priorityQueue data structure

class Solution{
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // your code here
        int [] result = new int [n + m];
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));
        for (int number : a) {
            pq.offer(number);
        }
        for (int number : b) {
            pq.offer(number);
        }
        int index = 0;
        while (!pq.isEmpty()) {
            result[index++] = pq.poll();
        }
        return result;
    }
}

// without directly using pq but by using the heapify concept

class Solution{
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // your code here
        int [] result = new int [n + m];
        int index = 0;
        for (int i=0; i<n; i++) {
            result[index++] = a[i];
        }
        for (int i=0; i<m; i++) {
            result[index++] = b[i];
        }
        // start from the non leaf node
        for (int i=result.length/2-1; i>=0; i--) {
            heapify(result, n + m, i);
        }
        return result;
    }
    
    public void heapify(int [] result, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && result[left] > result[largest]) {
            largest = left;
        }
        if (right < n && result[right] > result[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(result, i, largest);
            heapify(result, n, largest);
        }
    }
    
    public void swap(int [] result, int i, int j) {
        int temp = result[i];
        result[i] = result[j];
        result[j] = temp;
    }
}