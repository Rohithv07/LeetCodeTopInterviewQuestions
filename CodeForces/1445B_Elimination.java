There is a famous olympiad, which has more than a hundred participants. The Olympiad consists of two stages: the elimination stage, and the final stage. At least a hundred participants will advance to the final stage. The elimination stage in turn consists of two contests.

A result of the elimination stage is the total score in two contests, but, unfortunately, the jury lost the final standings and has only standings for the first and for the second contest separately.

In each contest, the participants are ranked by their point score in non-increasing order. When two participants have a tie (earned the same score), they are ranked by their passport number (in accordance with local regulations, all passport numbers are distinct).

In the first contest, the participant on the 100-th place scored a points. Also, the jury checked all participants from the 1-st to the 100-th place (inclusive) in the first contest and found out that all of them have at least b points in the second contest.

Similarly, for the second contest, the participant on the 100-th place has c points. And the jury checked that all the participants from the 1-st to the 100-th place (inclusive) have at least d points in the first contest.

After two contests, all participants are ranked by their total score in two contests in non-increasing order. When participants have the same total score, tie-breaking with passport numbers is used. The cutoff score to qualify to the final stage is the total score of the participant on the 100-th place.

Given integers a, b, c, d, please help the jury determine the smallest possible value of the cutoff score.

Input
You need to process t test cases.

The first line contains an integer t (1≤t≤3025) — the number of test cases. Then descriptions of t test cases follow.

The first line of each test case contains four integers a, b, c, d (0≤a,b,c,d≤9; d≤a; b≤c).

One can show that for any test case satisfying the constraints above, there is at least one olympiad scenario possible.

Output
For each test case print a single integer — the smallest possible cutoff score in some olympiad scenario satisfying the given information.

Example
inputCopy
2
1 2 2 1
4 8 9 2
outputCopy
3
12
Note
For the first test case, consider the following olympiad scenario: there are 101 participants in the elimination stage, each having 1 point for the first contest and 2 points for the second contest. Hence the total score of the participant on the 100-th place is 3.

For the second test case, consider the following olympiad scenario:

there are 50 participants with points 5 and 9 for the first and second contest respectively;
50 participants with points 4 and 8 for the first and second contest respectively;
and 50 participants with points 2 and 9 for the first and second contest respectively.
Hence the total point score of the participant on the 100-th place is 12.




import java.util.*;

public class Solution {
    // just find the max of a+b and c+d
    public static int findCutOff(int a, int b, int c, int d) {
        return Math.max(a+b, c+d);
    }
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            System.out.println(findCutOff(a, b, c, d));
        }
    }
}
