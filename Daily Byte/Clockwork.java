/*
You are given a list of strings, times, where each string represent a timestamp of a twenty-four hour clock (i.e. hours and minutes - “HH:MM”). Return the minimum difference, in minutes, between any two of the timestamps in the list.

Ex: Given the following times…

times = ["01:00", "01:10"], return 10 (i.e. there are 10 minutes between the two times).
Ex: Given the following times…

times = ["00:00", "12:23", "05:50", "23:12"], return 48.
*/


public class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] mark = new boolean[24 * 60];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);
            if (mark[h * 60 + m]) return 0;
            mark[h * 60 + m] = true;
        }
        
        int prev = 0, min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for (int i = 0; i < 24 * 60; i++) {
            if (mark[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }
        
        min = Math.min(min, (24 * 60 - last + first));
        
        return min;
    }
}