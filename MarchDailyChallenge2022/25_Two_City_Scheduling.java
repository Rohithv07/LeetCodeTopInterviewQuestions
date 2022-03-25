A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti], the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.

Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.

 

Example 1:

Input: costs = [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
Example 2:

Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
Output: 1859
Example 3:

Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
Output: 3086
 

Constraints:

2 * n == costs.length
2 <= costs.length <= 100
costs.length is even.
1 <= aCosti, bCosti <= 1000







// here we send all the people to A and calculate the total cost
        // now we calculate the refund, ie what happens if we send to B instead of A
        // this is find by calculating cost[1] - cost[0]
        // now if the value is -ve, then we have a huge refund to get and it will minimuize the cost
        // sort this array and take the refund amount until the people semd to A become equal to people send to B



class Solution {
    public int twoCitySchedCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int length = costs.length;
        int totalCost = 0;
        for (int [] cost : costs) {
            totalCost += cost[0];
        }
        int [] refund = new int [length];
        int peopleForB = length / 2; // these many amount of people to be send to either A or B
        int index = 0;
        for (int [] cost : costs) {
            refund[index++] = cost[1] - cost[0];
        }
        Arrays.sort(refund);
        for (int i = 0; i < peopleForB; i++) {
            totalCost += refund[i];
        }
        return totalCost;
    }
}