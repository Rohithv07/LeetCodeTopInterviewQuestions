// https://practice.geeksforgeeks.org/contest/interview-series-swiggy-5352/problems/

class Solution {
    long minimizeSum(int n, int arr[]) {
        // code here
        long sum = 0;
        PriorityQueue<Long> minHeap = new PriorityQueue<>((n1, n2) -> Long.compare(n1, n2));
        for (int num : arr) {
            minHeap.offer((long)num);
        }
        while (minHeap.size() > 1) {
            long top1 = minHeap.poll();
            long top2 = minHeap.poll();
            long current = top1 + top2;
            sum += current;
            minHeap.offer(current);
        }
        return sum;
    }
}