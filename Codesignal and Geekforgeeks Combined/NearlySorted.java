Given an array of n elements, where each element is at most k away from its target position, you need to sort the array optimally.

Example 1:

Input:
n = 7, k = 3
arr[] = {6,5,3,2,8,10,9}
Output: 2 3 5 6 8 9 10
Explanation: The sorted array will be
2 3 5 6 8 9 10
Example 2:

Input:
n = 5, k = 2
arr[] = {3,1,4,2,5}
Output: 1 2 3 4 5 
Note: DO NOT use STL sort() function for this question.

Your Task:
You are required to complete the method nearlySorted() which takes 3 arguments and returns the sorted array.

Expected Time Complexity : O(nlogk)
Expected Auxilliary Space : O(n)

Constraints:
1 ≤ n ≤ 106
1 ≤ k < n
1 ≤ arri ≤ 107


class Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        // your code here
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int number : arr) {
            minHeap.offer(number);
            if (minHeap.size() > k) {
                result.add(minHeap.poll());
            }
        }
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }
}
