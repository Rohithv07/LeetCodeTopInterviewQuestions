Given a string str consisting of digits, one may group these digits into sub-groups while maintaining their original order.
The task is to count number of groupings such that for every sub-group except the last one, sum of digits in a sub-group is less than or equal to sum of the digits in the sub-group immediately on its right.

For example, a valid grouping of digits of number 1119 is (1-11-9). Sum of digits in first subgroup is 1, next subgroup is 2, and last subgroup is 9. Sum of every subgroup is less than or equal to its immediate right.
 

Example 1: 

Input: str = "1119"
Output: 7
Explanation: [1-119], [1-1-19], [1-11-9], 
[1-1-1-9], [11-19], [111-9] and [1119] 
are seven sub-groups.

Example 2:

Input: str = "12"
Output: 2
Explanation: [1-2] and [12] are two sub-groups.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function TotalCount() which takes the string str as input parameter and returns total possible groupings.

Expected Time Complexity: O(N * N ) where N is length of string.
Expected Space Complexity: O(N * N)
 

Constraints:
1 <= length of string <= 100


int TotalCount(string A){
        int S = 0, n = A.size();
        for(char c: A)  S += (c-'0');
        vector<vector<int>> dp(A.size()+1, vector<int>(S+1,0));
        for(int s=0; s<=S; s++)   dp[n][s] = 1;
        for(int start=n-1; start>=0; start--){
            for(int prev_sum=0; prev_sum<=S; prev_sum++){
                int sum = 0, res = 0;
                for(int i=start;i<n;i++){
                    sum += (A[i]-'0');
                    if(sum >= prev_sum)
                        dp[start][prev_sum] += dp[i+1][sum];
                }
            }
	    }
	    return dp[0][0];
	}