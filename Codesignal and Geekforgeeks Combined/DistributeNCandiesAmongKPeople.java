Given N candies and K people. In the first turn, the first person gets 1 candy, the second gets 2 candies, and so on till K people. In the next turn, the first person gets K+1 candies, the second person gets K+2 candies and so on. If the number of candies is less than the required number of candies at every turn, then the person receives the remaining number of candies. Find the total number of candies every person has at the end.

 

Example 1:

Input:
N = 7, K = 4
Output:
1 2 3 1
Explanation:
At the first turn, the fourth person
has to be given 4 candies, but there is
only 1 left, hence he takes only one. 
Example 2:
Input:
N = 10, K = 3
Output :
5 2 3
Explanation:
At the second turn first one receives
4 and then we have no more candies left. 


Your Task:  
You don't need to read input or print anything. Your task is to complete the function distributeCandies() which takes 2 integers N and K as input and returns a list, where the ith integer denotes the number of candies the ith person gets.


Expected Time Complexity: O(logN+K)
Expected Auxiliary Space: O(K)


Constraints:
1 ≤ N ≤ 108
1 ≤ K ≤ 100


class Solution {
    static Long[] distributeCandies(int n, int k) {
        // code here
        Long [] candies = new Long[k];
        int index = 0;
        Long countCandy = 1L;
        for (int i=0; i<k; i++) {
            candies[i] = 0L;
        }
        while (n > 0) {
            if (countCandy <= n)
                candies[index % k] += countCandy;
            else
                candies[index % k] += n;
            n -= countCandy;
            countCandy += 1;
            index = (index + 1) % k;
        }
        // if (countCandy > 0) {
        //     candies[index % k] = countCandy;
        // }
        return candies;
    }
}