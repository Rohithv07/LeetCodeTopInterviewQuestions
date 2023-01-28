Given a data stream input of non-negative integers a1, a2, ..., an, summarize the numbers seen so far as a list of disjoint intervals.

Implement the SummaryRanges class:

SummaryRanges() Initializes the object with an empty stream.
void addNum(int value) Adds the integer value to the stream.
int[][] getIntervals() Returns a summary of the integers in the stream currently as a list of disjoint intervals [starti, endi]. The answer should be sorted by starti.
 

Example 1:

Input
["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
[[], [1], [], [3], [], [7], [], [2], [], [6], []]
Output
[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]

Explanation
SummaryRanges summaryRanges = new SummaryRanges();
summaryRanges.addNum(1);      // arr = [1]
summaryRanges.getIntervals(); // return [[1, 1]]
summaryRanges.addNum(3);      // arr = [1, 3]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
summaryRanges.addNum(7);      // arr = [1, 3, 7]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
 

Constraints:

0 <= value <= 104
At most 3 * 104 calls will be made to addNum and getIntervals.
 

Follow up: What if there are lots of merges and the number of disjoint intervals is small compared to the size of the data stream?

class SummaryRanges {
TreeSet<int[]> set;
public SummaryRanges() {
    set = new TreeSet<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
}

public void addNum(int val) {
    int[] interval = new int[]{val, val};
    if(set.contains(interval)) return;
    int[] high = set.higher(interval);
    int[] low = set.lower(interval);
    
    if(high != null && high[0] == val + 1 && low != null && low[1] == val - 1) {
        high[0] = low[0];
        set.remove(low);
    }
    else if(high != null && high[0] == val + 1)
        high[0]--;
    else if(low != null && low[1] == val - 1)
        low[1]++;
    else if((high != null && high[0] == val) || (low != null && low[1] >= val && low[0] <= val))
        return;
    else      
        set.add(interval);
}

public int[][] getIntervals() {
    List<int[]> list = new ArrayList<>();
    for(int[] interval : set) list.add(interval);
    return list.toArray(new int[0][]);
}
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */