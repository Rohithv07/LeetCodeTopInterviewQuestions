You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to the closest person.

 

Example 1:


Input: seats = [1,0,0,0,1,0,1]
Output: 2
Explanation: 
If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
Example 2:

Input: seats = [1,0,0,0]
Output: 3
Explanation: 
If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
Example 3:

Input: seats = [0,1]
Output: 1
 

Constraints:

2 <= seats.length <= 2 * 104
seats[i] is 0 or 1.
At least one seat is empty.
At least one seat is occupied.



/*
Intuition

In a group of K adjacent empty seats between two people, the answer is (K+1) / 2.

Algorithm

For each group of K empty seats between two people, we can take into account the candidate answer (K+1) / 2.

For groups of empty seats between the edge of the row and one other person, the answer is K, and we should take into account those answers too.

*/

class Solution {
    public int maxDistToClosest(int[] seats) {
        if (seats.length == 2)
            return 1;
        int answer = 0;
        int k = 0;
        for (int i=0; i<seats.length; i++) {
            if (seats[i] == 1)
                k = 0;
            else {
                k += 1;
                answer = Math.max(answer, (k+1)/2);
            }
        }
        for (int i=0; i<seats.length; i++) {
            if (seats[i] == 1) {
                answer = Math.max(answer, i);
                break;
            }
        }
        for (int i=seats.length-1; i>=0; i--) {
            if (seats[i] == 1) {
                answer = Math.max(answer, seats.length - 1 - i);
                break;
            }
        }
        return answer;
    }
}
