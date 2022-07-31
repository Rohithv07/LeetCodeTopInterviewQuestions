// https://practice.geeksforgeeks.org/contest/interview-series-61/problems/#


// https://www.youtube.com/watch?v=F-lpfJSHyI4


// can be done by sorting the starting time and finding the overlapping intervals
class Solution {
    public static int minimumRooms(int n, int[] start, int[] end) {
        // code here
        if (n == 1) {
            return 1;
        }
        Pair [] pair = new Pair[n];
        for (int i = 0; i < n; i++) {
            pair[i] = new Pair(start[i], end[i]);
        }
        Arrays.sort(pair, (p1, p2) -> Integer.compare(p1.startTime, p2.startTime));
        int rooms = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(pair[0].endTime);
        for (int i = 1; i < n; i++) {
            int currentStart = pair[i].startTime;
            int currentEnd = pair[i].endTime;
            if (currentStart <= pq.peek()) {
                rooms++;
            }
            else {
                pq.poll();
            }
            pq.offer(currentEnd);
        }
        return rooms;
    }
}

class Pair {
    int startTime;
    int endTime;
    
    public Pair(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}


// more optimal way is by using a hashmap kind of approach which will try to
// find the how many intervals have crossed at a particular area
// then the maximum among them gives the total number of rooms required


class Solution {
    public static int minimumRooms(int n, int[] start, int[] end) {
        // code here
        int [] frequency = new int [2400];
        // we do frequency[start[i]]++
        // and frequency[end[i] + 1]-- becuase after end[i] that particular interval have no effect
        
        for (int i = 0; i < n; i++) {
            frequency[start[i]]++;
            frequency[end[i] + 1]--;
        }
        int numberOfRooms = 0;
        for (int i = 1; i < 2400; i++) {
            frequency[i] += frequency[i - 1];
        }
        for (int i = 0; i < 2400; i++) {
            numberOfRooms = Math.max(numberOfRooms, frequency[i]);
        }
        return numberOfRooms;
    }
}
        

        


