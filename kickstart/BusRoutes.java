Problem
Bucket is planning to make a very long journey across the countryside by bus. Her journey consists of N bus routes, numbered from 1 to N in the order she must take them. The buses themselves are very fast, but do not run often. The i-th bus route only runs every Xi days.

More specifically, she can only take the i-th bus on day Xi, 2Xi, 3Xi and so on. Since the buses are very fast, she can take multiple buses on the same day.

Bucket must finish her journey by day D, but she would like to start the journey as late as possible. What is the latest day she could take the first bus, and still finish her journey by day D?

It is guaranteed that it is possible for Bucket to finish her journey by day D.

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with a line containing the two integers N and D. Then, another line follows containing N integers, the i-th one is Xi.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the latest day she could take the first bus, and still finish her journey by day D.

Limits
Time limit: 10 seconds per test set.
Memory limit: 1GB.
1 ≤ T ≤ 100.
1 ≤ Xi ≤ D.
1 ≤ N ≤ 1000.
It is guaranteed that it is possible for Bucket to finish her journey by day D.
Test set 1
1 ≤ D ≤ 100.
Test set 2
1 ≤ D ≤ 1012.
Sample

Input
 	
Output
 
3
3 10
3 7 2
4 100
11 10 5 50
1 1
1

  
Case #1: 6
Case #2: 99
Case #3: 1

  
In Sample Case #1, there are N = 3 bus routes and Bucket must arrive by day D = 10. She could:

Take the 1st bus on day 6 (X1 = 3),
Take the 2nd bus on day 7 (X2 = 7) and
Take the 3rd bus on day 8 (X3 = 2).
In Sample Case #2, there are N = 4 bus routes and Bucket must arrive by day D = 100. She could:

Take the 1st bus on day 99 (X1 = 11),
Take the 2nd bus on day 100 (X2 = 10),
Take the 3rd bus on day 100 (X3 = 5) and
Take the 4th bus on day 100 (X4 = 50),
In Sample Case #3, there is N = 1 bus route and Bucket must arrive by day D = 1. She could:

Take the 1st bus on day 1 (X1 = 1).




import java.util.*;

public class Solution {
    
    public static long busRoute(long [] bus, long d, int n) {
        if (bus.length == 1 && d == 1)
            return 1;
        long low = 0;
        long high = d;
        while (low < high) {
            long middle = (low + high + 1) / 2;
            if (possible(middle, n, bus, d))
                low = middle;
            else
                high = middle - 1;
        }
        return low;
    }
    
    public static boolean possible(long middle, int n, long [] bus, long d) {
        for (int i=0; i<n; i++) {
            if (middle % bus[i] != 0)
                middle += (bus[i] - middle % bus[i]);
        }
        return middle <= d;
    }
    
    
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t=1; t<=test; t++) {
            int n = sc.nextInt();
            long d = sc.nextLong();
            long [] bus = new long[n];
            for (int i=0; i<n; i++)
                bus[i] = sc.nextLong();
            System.out.println("Case #" + t + ": " + busRoute(bus, d, n));
        }
    }
}
