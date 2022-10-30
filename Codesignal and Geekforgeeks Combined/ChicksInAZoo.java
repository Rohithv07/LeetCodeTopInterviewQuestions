Initially, the zoo have a single chick. A chick gives birth to 2 chicks every day and the life expectancy of a chick is 6 days. Zoo officials want to buy food for chicks so they want to know the number of chicks on an Nth day. Help the officials with this task.
 

Example 1:

Input: N = 2 
Output: 3
Explanation: First day there is only 1 chick.
On second day total number of chicks = 3. 
Example 2:

Input: N = 3
Output: 9
Explanation: First day there is only 1 chick.
On second day total number of chicks = 3.
On third day total number of chicks = 9
 

Your Task:
You don't need to read or print anything, Your task is to complete the function NoOfChicks() which takes N as the input parameter and returns the total no. of chicks on the Nth day.
 

Expected Time Complexity: O(N)
Expected Space Complexity: O(N)
 

Constraints:
1 <= N <= 35



//User function Template for Java

class Solution
{
    public long NoOfChicks(int n)
    {
        // Code here
        // return 
        long [] lastChickCount = new long [n + 1];
        long chickSum = 1;
        lastChickCount[0] = 0;
        lastChickCount[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i >= 6) {
                chickSum -= lastChickCount[i - 6]; // chicks life time is 6 days
            }
            lastChickCount[i] = chickSum * 2;
            chickSum *= 3;
        }
        return chickSum;
    }
}