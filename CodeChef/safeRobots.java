There are two robots, one belonging to Alice, and the other to Bob. These robots are currently standing in a lane. You are given this information by a string s, whose characters are either '.' denoting empty cell, 'A' denoting Alice's robot, or 'B' denoting Bob's robot. We guarantee that Alice's robot lies to the left of Bob's robot.

You are given two integers sa, and sb. Alice's robot moves to the right, and in a single step it jumps sa cells to the right. Whereas Bob's robot moves to the left, and in a single step it jumps sb cells to the left. Both robots take 1 step per second. If initially, Alice's robot was at index 5, and sa=4, then after 1 second, Alice's robot would be at index 9. Note that it does not go to cells in between. It directly jumps to cell 9. Also note that the robots don't step out of the given cells, i.e., they stop moving if the next step they take is out of the cells. And once some robot stops moving, the entire simulation stops, and the other robot also stops moving.

Find whether at any point of time, the robots will land on the same cell or not. If they fall into the same cell, they will collide with each other, and it will create an unsafe undesired situation.

Input:
The first line will contain an integer T, denoting the number of test cases. Then the test cases follow.
The first line of each test case contains a string s.
The second line of each test case contains two space-separated integers sa,sb.
Output:
For each test case, output "safe" if there is no point in time, when the robots collide with each other. Otherwise print "unsafe".

Constraints
1≤T≤10
1≤|s|≤105
1≤sa,sb≤|s|
Sample Input:
2
A..B
1 1
A...B
1 1
Sample Output:
safe
unsafe
Explanation
In the first test case, at no point in time, A and B will collide with each other. Thus, it is a safe situation.
In the second test case, at t=2 second, A and B will both be at the 3-rd index (1-based indexing). Thus it is unsafe.




import java.util.*;
public class Main {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            String position = sc.next();
            int sa = sc.nextInt();
            int sb = sc.nextInt();
            int alice = 0;
            int bob = 0;
            for (char ch : position.toCharArray()) {
                if (ch == 'A')
                    alice = position.indexOf(ch);
                else if (ch == 'B')
                    bob = position.indexOf(ch);
            }
            boolean safe = false;
            while (alice <= bob) {
                if (alice == bob) {
                    safe = false;
                    break;
                }
                else {
                    safe = true;
                }
                alice += sa;
                bob -= sb;
            }
            if (!safe)
                System.out.println("unsafe");
            else
                System.out.println("safe");
        }
    }
}

