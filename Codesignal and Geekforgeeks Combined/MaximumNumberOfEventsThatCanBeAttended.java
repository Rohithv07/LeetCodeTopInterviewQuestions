There are N events in Geek's city. You are given two arrays start[] and end[] denoting starting and ending day of the events respectively. Event i starts at start[i] and ends at end[i].
You can attend an event i at any day d between start[i] and end[i] (start[i] ≤ d ≤ end[i]). But you can attend only one event in a day.
Find the maximum number of events you can attend.

 

Example 1:

Input:
N = 3
start[] = {1, 2, 1}
end[] = {1, 2, 2}
Output:
2
Explanation:
You can attend a maximum of two events.
You can attend 2 events by attending 1st event
at Day 1 and 2nd event at Day 2.
Example 2:
Input:
N = 3
start[i] = {1, 2, 3}
end[i] = {2, 3, 4} 
Output :
3
Explanation:
You can attend all events by attending event 1
at Day 1, event 2 at Day 2, and event 3 at Day 3.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function maxEvents() which takes an integer N and two arrays start[], and end[] of size N as input parameters and returns the maximum number of events that can be attended by you.


Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105
1 ≤ start[i] ≤ end[i] ≤ 105


class Solution {
    static int maxEvents(int[] start, int[] end, int n) {
        // code here
        Pair [] pairArray = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairArray[i] = new Pair(start[i], end[i]);
        }
        Arrays.sort(pairArray, (pair1, pair2) -> Integer.compare(pair1.getStart(), pair2.getStart()));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int index = 0;
        int dayCount = 0;
        for (int day = 1; day <= 100000; day++) {
            while (index < n && pairArray[index].getStart() == day) {
                minHeap.offer(pairArray[index++].getEnd());
            }
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                dayCount += 1;
                minHeap.poll();
            }
        }
        return dayCount;
    }
}

class Pair {
    private int start;
    private int end;
    
    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    public int getStart() {
        return start;
    }
    
    public int getEnd() {
        return end;
    }
}