There are n districts in the town, the i-th district belongs to the ai-th bandit gang. Initially, no districts are connected to each other.

You are the mayor of the city and want to build n−1 two-way roads to connect all districts (two districts can be connected directly or through other connected districts).

If two districts belonging to the same gang are connected directly with a road, this gang will revolt.

You don't want this so your task is to build n−1 two-way roads in such a way that all districts are reachable from each other (possibly, using intermediate districts) and each pair of directly connected districts belong to different gangs, or determine that it is impossible to build n−1 roads to satisfy all the conditions.

You have to answer t independent test cases.

Input
The first line of the input contains one integer t (1≤t≤500) — the number of test cases. Then t test cases follow.

The first line of the test case contains one integer n (2≤n≤5000) — the number of districts. The second line of the test case contains n integers a1,a2,…,an (1≤ai≤109), where ai is the gang the i-th district belongs to.

It is guaranteed that the sum of n does not exceed 5000 (∑n≤5000).

Output
For each test case, print:

NO on the only line if it is impossible to connect all districts satisfying the conditions from the problem statement.
YES on the first line and n−1 roads on the next n−1 lines. Each road should be presented as a pair of integers xi and yi (1≤xi,yi≤n;xi≠yi), where xi and yi are two districts the i-th road connects.
For each road i, the condition a[xi]≠a[yi] should be satisfied. Also, all districts should be reachable from each other (possibly, using intermediate districts).

Example
inputCopy
4
5
1 2 2 1 3
3
1 1 1
4
1 1000 101 1000
4
1 2 3 4
outputCopy
YES
1 3
3 5
5 4
1 2
NO
YES
1 2
2 3
3 4
YES
1 2
1 3
1 4



import java.util.*;

public class Solution {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int [] array = new int [n];
            int count = 0;
            for (int i=0; i<n; i++) {
                array[i] = sc.nextInt();
                if (array[i] == array[0])
                    count += 1;
            }
            if (count == n)  // only one number inputted so NO
                System.out.println("NO");
            else {
                System.out.println("YES");
                for (int i=1; i<n; i++) {
                    int j = 0;
                    while (array[i] == array[j])
                        j += 1;
                    System.out.println(i+1 + " " + (j+1));
                }
            }
        }
    }
}
