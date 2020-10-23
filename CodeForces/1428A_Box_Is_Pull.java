Wabbit is trying to move a box containing food for the rest of the zoo in the coordinate plane from the point (x1,y1) to the point (x2,y2).

He has a rope, which he can use to pull the box. He can only pull the box if he stands exactly 1 unit away from the box in the direction of one of two coordinate axes. He will pull the box to where he is standing before moving out of the way in the same direction by 1 unit.


For example, if the box is at the point (1,2) and Wabbit is standing at the point (2,2), he can pull the box right by 1 unit, with the box ending up at the point (2,2) and Wabbit ending at the point (3,2).

Also, Wabbit can move 1 unit to the right, left, up, or down without pulling the box. In this case, it is not necessary for him to be in exactly 1 unit away from the box. If he wants to pull the box again, he must return to a point next to the box. Also, Wabbit can't move to the point where the box is located.

Wabbit can start at any point. It takes 1 second to travel 1 unit right, left, up, or down, regardless of whether he pulls the box while moving.

Determine the minimum amount of time he needs to move the box from (x1,y1) to (x2,y2). Note that the point where Wabbit ends up at does not matter.

Input
Each test contains multiple test cases. The first line contains a single integer t (1≤t≤1000): the number of test cases. The description of the test cases follows.

Each of the next t lines contains four space-separated integers x1,y1,x2,y2 (1≤x1,y1,x2,y2≤109), describing the next test case.

Output
For each test case, print a single integer: the minimum time in seconds Wabbit needs to bring the box from (x1,y1) to (x2,y2).

Example
inputCopy
2
1 2 2 2
1 1 2 2
outputCopy
1
4
Note
In the first test case, the starting and the ending points of the box are (1,2) and (2,2) respectively. This is the same as the picture in the statement. Wabbit needs only 1 second to move as shown in the picture in the statement.

In the second test case, Wabbit can start at the point (2,1). He pulls the box to (2,1) while moving to (3,1). He then moves to (3,2) and then to (2,2) without pulling the box. Then, he pulls the box to (2,2) while moving to (2,3). It takes 4 seconds.


import java.util.*;
public class Solution {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int dist1 = Math.abs(x1-x2) + Math.abs(y1-y2);
            System.out.println((x1 == x2) || (y1 == y2) ? dist1: dist1 + 2);
        }
    }
}
