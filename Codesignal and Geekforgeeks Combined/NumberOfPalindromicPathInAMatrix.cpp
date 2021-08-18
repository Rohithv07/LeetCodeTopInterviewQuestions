Given a matrix containing lower alphabetical characters only of size n*m. We need to count the number of palindromic paths in the given matrix.
A path is defined as a sequence of cells starting from top-left cell and ending at bottom-right cell. We are allowed to move to right and down only from current cell.
 

Example 1:

Input: matrix = {{a,a,a,b},{b,a,a,a},{a,b,b,a}}
Output: 3
Explanation: Number of palindromic paths are 3 
from top-left to bottom-right.
aaaaaa (0, 0) -> (0, 1) -> (1, 1) -> (1, 2) -> 
(1, 3) -> (2, 3)    
aaaaaa (0, 0) -> (0, 1) -> (0, 2) -> (1, 2) -> 
(1, 3) -> (2, 3)    
abaaba (0, 0) -> (1, 0) -> (1, 1) -> (1, 2) -> 
(2, 2) -> (2, 3)
Example 2:

Input: matrix = {{a,b},{c,d}}
Output: 0
Explanation: There is no palindromic paths.
 

Your Task:
You dont need to read or print anyhting. Your task is to complete the function countPalindromicPaths() which takes the matrix as input parameter and returns the total nuumber of palindromic paths modulo 109 + 7.
 

Expected Time Complexity: O(n2*m2)
Space Complexity: O(n*m)
 

Constraints:
1 ≤ n, m ≤ 100



class Solution {
  public:
  const int m=1000000007;
    unordered_map<string, long long>mp;
    int countPalindromicPaths(vector<vector<char>>arr){
        // Code here
        mp.clear();
        return f(arr, 0, 0, arr.size()-1, arr[0].size()-1)%m;
    }
    int f(vector<vector<char>>&arr, int i, int j, int p, int q){
        if(i>=arr.size() || j>=arr[0].size() || p<0 || q<0) return 0;
        if(arr[i][j]!=arr[p][q]) return 0;

        if((i==p && j==q) || abs(i-p)==1&&(j-q)==0 || (i-p)==0&&abs(j-q)==1) return 1;        
        if(i>p || j>q) return 0;//second pointer at left of first
        
        string curr=to_string(i)+'&'+to_string(j)+'&'+to_string(p)+'&'+to_string(q);
        if(mp.find(curr)!=mp.end()) return mp[curr];

        long long op1=f(arr, i, j+1, p, q-1)%m;
        long long op2=f(arr, i, j+1, p-1, q)%m;
        long long op3=f(arr, i+1, j, p, q-1)%m;
        long long op4=f(arr, i+1, j, p-1, q)%m;
        return mp[curr]=(op1+op2+op3+op4)%m;
    }
};