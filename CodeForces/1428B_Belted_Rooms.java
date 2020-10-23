In the snake exhibition, there are n rooms (numbered 0 to n−1) arranged in a circle, with a snake in each room. The rooms are connected by n conveyor belts, and the i-th conveyor belt connects the rooms i and (i+1)modn. In the other words, rooms 0 and 1, 1 and 2, …, n−2 and n−1, n−1 and 0 are connected with conveyor belts.

The i-th conveyor belt is in one of three states:

If it is clockwise, snakes can only go from room i to (i+1)modn.
If it is anticlockwise, snakes can only go from room (i+1)modn to i.
If it is off, snakes can travel in either direction.

Above is an example with 4 rooms, where belts 0 and 3 are off, 1 is clockwise, and 2 is anticlockwise.

Each snake wants to leave its room and come back to it later. A room is returnable if the snake there can leave the room, and later come back to it using the conveyor belts. How many such returnable rooms are there?

Input
Each test contains multiple test cases. The first line contains a single integer t (1≤t≤1000): the number of test cases. The description of the test cases follows.

The first line of each test case description contains a single integer n (2≤n≤300000): the number of rooms.

The next line of each test case description contains a string s of length n, consisting of only '<', '>' and '-'.

If si= '>', the i-th conveyor belt goes clockwise.
If si= '<', the i-th conveyor belt goes anticlockwise.
If si= '-', the i-th conveyor belt is off.
It is guaranteed that the sum of n among all test cases does not exceed 300000.

Output
For each test case, output the number of returnable rooms.

Example
inputCopy
4
4
-><-
5
>>>>>
3
<--
2
<>
outputCopy
3
5
3
0
Note
In the first test case, all rooms are returnable except room 2. The snake in the room 2 is trapped and cannot exit. This test case corresponds to the picture from the problem statement.

In the second test case, all rooms are returnable by traveling on the series of clockwise belts.


import java.util.*;

public class Solution {
    public static int beltedRooms(String s, int n) {
        int count = 0;
        boolean one = true;
        boolean two = true;
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '<')
                one = false;
            if (s.charAt(i) == '>')
                two = false;
        }
        if (one || two)
            return n;
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '-' || s.charAt((i+1)%n) == '-')
                count += 1;
        }
        return count;
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            System.out.println(beltedRooms(s, n));
        }
    }
}
