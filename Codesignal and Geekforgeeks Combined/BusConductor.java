// https://practice.geeksforgeeks.org/contest/interview-series-66/problems/#


class Solution {
    public static int findMoves(int n, int[] chairs, int[] passengers) {
        // code here
        Arrays.sort(chairs);
        Arrays.sort(passengers);
        int minimumChange = 0;
        for (int i = 0; i < n; i++) {
            int chair = chairs[i];
            int passenger = passengers[i];
            int moveTookPlace = Math.abs(chair - passenger);
            minimumChange += moveTookPlace;
        }
        return minimumChange;
    }
}