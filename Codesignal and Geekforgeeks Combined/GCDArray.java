// https://practice.geeksforgeeks.org/contest/interview-series-64/problems/#


// https://www.youtube.com/watch?v=oIo8kqdEgJk


class Solution {
    public static int solve(int n, int k, int[] arr) {
        // code here
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        int threshold = (int)Math.sqrt(total);
        List<Integer> divisor = new ArrayList<>();
        for (int i = 1; i <= threshold; i++) {
            if (total % i == 0) {
                divisor.add(i);
                divisor.add(total / i);
            }
        }
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }
        int answer = 0;
        for (int g : divisor) {
            int partitions = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] % g == 0) {
                    partitions++;
                }
            }
            if (partitions >= k) {
                answer = Math.max(answer, g);
            }
        }
        return answer;
    }
}
        
