We have N persons sitting on a round table. Any person can do a handshake with any other person.

     1
2         3
     4

Handshake with 2-3 and 1-4 will cause cross.

In how many ways these N people can make handshakes so that no two handshakes cross each other. N would be even. 
 

Example 1:

Input:
N = 2
Output:
1
Explanation:
{1,2} handshake is
possible.
Example 2:

Input:
N = 4
Output:
2
Explanation:
{{1, 2}, {3, 4}} are the
two handshakes possible.
{{1, 3}, {2, 4}} is another
set of handshakes possible.

Your Task:
You don't need to read input or print anything. Your task is to complete the function count() which takes an integer N as input parameters and returns an integer, the total number of handshakes possible so that no two handshakes cross each other.
 

Expected Time Complexity: O(2N)
Expected Space Complexity: O(1)
 

Constraints:
1 <= N <= 30

class Solution{
    static int count(int n) 
    { 
        // code here
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 1) {
            return 0;
        }
        int result = 0;
        for (int i=0; i<n; i+=2) {
            result += count(i) * count(n - 2 - i);
        }
        return result;
    }
}