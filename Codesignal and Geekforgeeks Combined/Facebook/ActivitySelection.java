Given N activities with their start and finish day given in array start[ ] and end[ ]. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a given day.
Note : Duration of the activity includes both starting and ending day.


Example 1:

Input:
N = 2
start[] = {2, 1}
end[] = {2, 2}
Output: 
1
Explanation:
A person can perform only one of the
given activities.
Example 2:

Input:
N = 4
start[] = {1, 3, 2, 5}
end[] = {2, 4, 3, 6}
Output: 
3
Explanation:
A person can perform activities 1, 2
and 4.

Your Task :
You don't need to read input or print anything. Your task is to complete the function activityselection() which takes array start[ ], array end[ ] and integer N as input parameters and returns the maximum number of activities that can be done.


Expected Time Complexity : O(N * Log(N))
Expected Auxilliary Space : O(N)

Constraints:
1 ≤ N ≤ 2*105
1 ≤ start[i] ≤ end[i] ≤ 109



class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        if (n == 0 || start == null || end == null)
            return 0;
        Pair [] pair = new Pair[n];
        for (int i=0; i<n; i++) {
            pair[i] = new Pair(start[i], end[i]);
        }
        Arrays.sort(pair, (p1, p2) -> Integer.compare(p1.end, p2.end));
        int count = 1;
        int i = 0;
        for (int j=1; j<n; j++) {
            // same day only 1 activity
            if (pair[j].start > pair[i].end) {
                i = j;
                count += 1;
            }
        }
        return count;
    }
}

class Pair {
    int start;
    int end;
    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}