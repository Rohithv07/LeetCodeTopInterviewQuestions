// https://practice.geeksforgeeks.org/contest/interview-series-57/problems/#

class Solution {
    public static boolean is_possible_to_get_seats(int n, int m, int[] seats) {
        // code here
        if (m == 1 && n > m) {
            return false;
        }
        if (n > m) {
            return false;
        }
        if (m == 1 && n == 1 && seats[0] == 0) {
            return true;
        }
        int count = 0;
        if (seats[0] == 0 && seats[1] == 0) {
            seats[0] = 1;
            count++;
        }
        for (int i = 1; i < m - 1; i++) {
            if (seats[i] == 0 && seats[i - 1] == 0 && seats[i + 1] == 0) {
                seats[i] = 1;
                count++;
            }
        }
        //System.out.println(count);
        if (count >= n) {
            return true;
        }
        if (seats[m - 1] == 0 && seats[m - 2] == 0) {
            count++;
        }
        return count >= n;
    }
}