You are given N pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. You have to find the longest chain which can be formed from the given set of pairs. 
 

Example 1:

Input:
N = 5
P[] = {5  24 , 39 60 , 15 28 , 27 40 , 50 90}
Output: 3
Explanation: The given pairs are { {5, 24}, {39, 60},
{15, 28}, {27, 40}, {50, 90} },the longest chain that
can be formed is of length 3, and the chain is
{{5, 24}, {27, 40}, {50, 90}}

Example 2:

Input:
N = 2
P[] = {5 10 , 1 11}
Output: 1
Explanation:The max length chain possible is only of
length one.
 

Your Task:
You don't need to read input or print anything. Your task is to Complete the function maxChainLen() which takes a structure p[] denoting the pairs and n as the number of pairs and returns the length of the longest chain formed.

 

Expected Time Complexity: O(Nlog(N))
Expected Auxiliary Space: O(1)

Constraints:
1<=N<=105


class CompareBySecond implements Comparator<Pair>
{
   public int compare(Pair a, Pair b)
    {
        return a.y - b.y;
    }
}


// this can also be done using Longest Increasing Subsequence technique
// a[i].first > a[j].second && dp[i] < dp[j] + 1 -> dp[i] = dp[j] + 1
class GfG
{
    int maxChainLength(Pair arr[], int n)
    {
       // your code here
       Arrays.sort(arr, new CompareBySecond());
       int count = 0;
       int previous = -1;
       for (Pair pair : arr) {
           if (previous < pair.x) {
               count++;
               previous = pair.y;
           }
       }
       return count;
    }
}