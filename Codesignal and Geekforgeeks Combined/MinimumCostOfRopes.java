class Solution{
    long minCost(long arr[], int n) {
        // your code here
        if (arr == null || n == 0)
            return 0;
        Arrays.sort(arr);
        long cost = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            pq.add(arr[i]);
        }
        while (pq.size() > 1) {
            long firstSmall = pq.poll();
            long secondSmall = pq.poll();
            cost += firstSmall + secondSmall;
            pq.add(firstSmall + secondSmall);
        }
        return cost;
    }
}