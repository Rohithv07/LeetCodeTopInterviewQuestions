You are given two strings s and t. Now your task is to print all longest common sub-sequences in lexicographical order.

Example 1:

Input: s = abaaa, t = baabaca
Output: aaaa abaa baaa
Example 2:

Input: s = aaa, t = a
Output: a

Your Task:
You do not need to read or print anything. Your task is to complete the function all_longest_common_subsequences() which takes string a and b as first and second parameter respectively and returns a list of strings which contains all possible longest common subsequences in lexicographical order.
 

Expected Time Complexity: O(n^4)
Expected Space Complexity: O(K * n) where K is a constant less than n.
 

Constraints:
1 <= Length of both strings <= 100



class Solution
{
	public:
		vector<string> all_longest_common_subsequences
		(string s, string t)
		{
		    vector<vector<int>> dp(s.length()+1 ,
		    vector<int>(t.length()+1 , 0));
		    
            vector<vector<unordered_set<string>>> dp_ans
            (s.length()+1 ,
            vector<unordered_set<string>>(t.length()+1));
            
            for(int i = 1 ; i < s.length()+1 ; i++){
                for(int j = 1 ; j < t.length()+1 ; j++){

                    if(s[i-1] == t[j-1]){
                        dp[i][j] = max(dp[i-1][j-1]+1 , 
                        max(dp[i][j-1] , dp[i-1][j]));
                    }
                    else{
                        dp[i][j] = max(dp[i][j-1] , dp[i-1][j]);
                    }
                }
            }
            
            for(int i = 0 ; i < s.length()+1 ; i++){
                dp_ans[i][0].insert("");
            }
            for(int i = 0 ; i < t.length()+1 ; i++){
                dp_ans[0][i].insert("");
            }

            for(int i = 1 ; i < s.length()+1 ; i++){
                for(int j = 1 ; j < t.length()+1 ; j++){
                    if(s[i-1] == t[j-1]){
                        for(auto it : dp_ans[i-1][j-1])
                            dp_ans[i][j].insert(it+s[i-1]);
                    }
                    if(dp[i][j] == dp[i-1][j]){
                        for(auto it : dp_ans[i-1][j])
                            dp_ans[i][j].insert(it);
                    }
                    if(dp[i][j] == dp[i][j-1]){
                        for(auto it : dp_ans[i][j-1])
                            dp_ans[i][j].insert(it);
                    }
                }
            }

            vector<string> ans;
            for(auto it : dp_ans[s.length()][t.length()]){
                if(it!="") ans.push_back(it);
            }
            sort(ans.begin() , ans.end());
            return ans;
		}
};
