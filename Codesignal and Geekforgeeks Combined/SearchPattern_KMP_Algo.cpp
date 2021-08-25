Given two strings, one is a text string, txt and other is a pattern string, pat. The task is to print the indexes of all the occurences of pattern string in the text string. For printing, Starting Index of a string should be taken as 1.


Example 1:

Input:
txt = "batmanandrobinarebat", pat = "bat"
Output: 1 18
Explanation: The string "bat" occurs twice
in txt, one starts are index 1 and the other
at index 18. 
Example 2:

Input: 
txt = "abesdu", pat = "edu"
Output: -1
Explanation: There's not substring "edu"
present in txt.

Your Task:
You don't need to read input or print anything. Your task is to complete the function search() which takes the string txt and the string pat as inputs and returns an array denoting the start indices (1-based) of substring pat in the string txt. 
Note: Return an empty list incase of no occurences of pattern. Driver will print -1 in this case.


Expected Time Complexity: O(|txt|).
Expected Auxiliary Space: O(|txt|).


Constraints:
1 ≤ |txt| ≤ 105
1 ≤ |pat| < |S|



class Solution
{
    public:
    
        void getlps(string s, vector<int> &lps){
            int n = s.length();
            int i = 0, j = 1;
            lps[0] = 0;
            
            while(j < n){
                if(s[i] == s[j]){
                    lps[j++] = i + 1;
                    i++;
                }
                
                else{
                    if(i != 0)
                        i = lps[i-1];
                    else
                        lps[j++] = 0;
                }
            }
        }
        vector<int> search(string pat, string txt){
            int pl = pat.length();
            int tl = txt.length();
            
            vector<int> res;
            vector<int> lps(pl, 0);
           
            getlps(pat, lps);
            
            int pi = 0, tj = 0;
            
            while(tj < tl){
                if(pat[pi] == txt[tj]){
                    pi++;        
                    tj++;
                }
                
                if(pi == pl){
                    res.push_back(tj - pi + 1);
                    pi = lps[pi - 1];
                }
                
                else if(tj < tl && pat[pi] != txt[tj]){
                    if(pi != 0)
                        pi = lps[pi -1];
                    
                    else
                        tj++;
                }
            }
        
            if(res.empty())
                return {-1};
                
            return res;
        }

     
};
