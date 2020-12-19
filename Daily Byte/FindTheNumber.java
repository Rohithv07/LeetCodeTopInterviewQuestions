Given an array of integers, nums, and a value k, return the kth largest element.

Ex: Given the following array nums…

[1, 2, 3], k = 1, return 3.
Ex: Given the following array nums…

[9, 2, 1, 7, 3, 2], k = 5, return 2.


class Solution {
    public int findKthLargest(int[] nums, int k) {
        // this is a minHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int number: nums) {
            pq.add(number);
            if (pq.size() > k)
                pq.remove();
        }
        return pq.remove();
    }
}

// nlogk as insertion of k elements in logk 
