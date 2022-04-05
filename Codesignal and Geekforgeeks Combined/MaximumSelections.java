Geek wants to select the maximum number of course bundles at the Geek Summer Carnival. 

You are given a finite number of courses and N range of numbers each depicting a bundle of courses. Select the maximum number of bundles such that no courses overlap in any of the bundle.

Note: The ending of a range being the same as start of another isn't considered as an overlap.


Example 1:

Input:
N = 4
Bundles = 
1 5
2 3
1 8
3 5

Output:
2

Explanation: 

We can select 2 bundles at max while 
staying true to the condition. For this, 
we can pick the ranges (2,3) and (3,5) 
without any overlap. 
 

Example 2:

Input:
N = 5
Bundles = 
7 9 
2 8 
1 3 
10 11 
10 16

Output:
3

Explanation: 

We can pick the ranges (1,3), 
(7,9) and (10,11) without any overlap.

Your Task:
You don't need to read input or print anything. Complete the function max_non_overlapping() that takes a 2D array representing N ranges as input parameter.  Return the maximum number of course bundles. 


Expected time complexity: O(NlogN)
Expected space complexity: O(1)


Constraints:
1 <= N <= 1000
0 <= range[i][j] <= 1000


// ranges[i][0] is the start of ith range
// ranges[i][1] is the end of ith range

class solver
{
    static int max_non_overlapping(int ranges[][], int n){
        // code here
        if (ranges == null || ranges.length == 0) {
            return 0;
        }
        Arrays.sort(ranges, (a, b) -> Integer.compare(a[1], b[1]));
        int remaining = 0;
        int end = Integer.MIN_VALUE;
        for (int [] range : ranges) {
            int currentStart = range[0];
            int currentEnd = range[1];
            if (currentStart >= end) {
                remaining++;
                end = currentEnd;
            }
        }
        return remaining;
    }
}