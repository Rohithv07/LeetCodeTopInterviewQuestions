A drawer contains socks of n different colours. The number of socks available of ith colour is given by a[i] where a is an array of n elements. Tony wants to take k pairs of socks out of the drawer. However, he cannot see the colour of the sock that he is picking. You have to tell what is the minimum number of socks Tony has to pick in one attempt from the drawer such that he can be absolutely sure, without seeing their colours, that he will have at least k matching pairs.

Example 1:

Input:
N = 4, K = 6
a[] = {3, 4, 5, 3}
Output: 15
Explanation: 
All 15 socks have to be picked in order
to obtain 6 pairs.
Example 2:

Input: N = 2, K = 3
a[] = {4, 6}
Output: 7
Explanation: The Worst case scenario after 6
picks can be {3,3} or {1,5} of each
coloured socks. Hence 7th pick will ensure
3rd pair. 
Your Task:  
You don't need to read input or print anything. Complete the function find_min() which takes the array a[], size of array N, and value K as input parameters and returns the minimum number of socks Tony has to pick. If it is not possible to pick then return -1.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105 
1 ≤ a[i] ≤ 106



// User function Template for Java

/*
Algorithm: We need to find the worst case. 
Initially take 1 socks of each color and reduce each element by 1. 
After that just try to keep every element as odd by picking pair of each color 
(if possible) and res++ accordingly. 
If socksPair is still less than k, then in another loop, 
take all remaining socks till we get K pairs. 
At last if we get K pairs then return res, otherwise return -1.
*/

class Solution {
    public int find_min(int[] a, int n, int k) {
        // code here.
        int result = n;
        int pair = 0;
        for (int i=0; pair < k && i < n; i++) {
            a[i]--;
            while (a[i] >= 2) {
                pair += 1;
                if (pair == k) {
                    result += 1;
                    break;
                }
                result += 2;
                a[i] -= 2;
            }
        }
        for (int i=0; pair < k && i < n; i++) {
            if (a[i] > 0) {
                pair++;
                result++;
            }
        }
        return pair == k ? result : -1;
    }
}