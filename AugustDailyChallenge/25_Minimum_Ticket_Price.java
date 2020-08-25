In a country popular for train travel, you have planned some train travelling one year in advance.  The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.

Train tickets are sold in 3 different ways:

a 1-day pass is sold for costs[0] dollars;
a 7-day pass is sold for costs[1] dollars;
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.

Return the minimum number of dollars you need to travel every day in the given list of days.

 

Example 1:

Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total you spent $11 and covered all the days of your travel.
Example 2:

Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation: 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total you spent $17 and covered all the days of your travel.
 

Note:

1 <= days.length <= 365
1 <= days[i] <= 365
days is in strictly increasing order.
costs.length == 3
1 <= costs[i] <= 1000


SOLUTION 1:
class Solution {
    int [] costs;
    int [] memo;
    Set<Integer> set = new HashSet<>();
    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new int[days[days.length-1]];
        for (int day: days)
            set.add(day);
        return dynamic(days[days.length-1]);
    }
    public int dynamic(int day) {
        if (day <= 0)
            return 0;
        if (memo[day-1] != 0)
            return memo[day-1];
        int minimumSum;
        if (set.contains(day)) {
            int one = dynamic(day-1) + costs[0];
            int seven = dynamic(day-7) + costs[1];
            int thirty = dynamic(day-30) + costs[2];
            minimumSum = Math.min(one, Math.min(seven, thirty));
        }
        else 
            minimumSum = dynamic(day-1);
        return memo[day-1] = minimumSum;
    }
}

Solution 2:

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int [] dynamicArray = new int [366];
        dynamicArray[0] = 0;
        int day = 0;
        for (int i=1; i<=365; i++) {
            if (day == days.length)
                break;
            if (days[day] != i) {
                dynamicArray[i] = dynamicArray[i-1];
            }
            else {
                int one = costs[0] + dynamicArray[i-1];
                int seven = costs[1] + dynamicArray[Math.max(0, i-7)];
                int thirty = costs[2] + dynamicArray[Math.max(0, i-30)];
                dynamicArray[i] = Math.min(one, (Math.min(seven, thirty)));
                day += 1;
            }
        }
        return dynamicArray[days[days.length-1]];
    }
}

