Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.
 

Example 1:

Input: 
N = 5, K = 4
dict = {"baa","abcd","abca","cab","cad"}
Output:
1
Explanation:
Here order of characters is 
'b', 'd', 'a', 'c' Note that words are sorted 
and in the given language "baa" comes before 
"abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.
Example 2:

Input: 
N = 3, K = 3
dict = {"caa","aaa","aab"}
Output:
1
Explanation:
Here order of characters is
'c', 'a', 'b' Note that words are sorted
and in the given language "caa" comes before
"aaa", therefore 'c' is before 'a' in output.
Similarly we can find other orders.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function findOrder() which takes  the string array dict[], its size N and the integer K as input parameter and returns a string denoting the order of characters in the alien language.


Expected Time Complexity: O(N * |S| + K) , where |S| denotes maximum length.
Expected Space Compelxity: O(K)


Constraints:
1 ≤ N, M ≤ 300
1 ≤ K ≤ 26
1 ≤ Length of words ≤ 50



class Solution{
    public:
    void DFSRec(vector<int> adj[], int u, stack<int> &st, vector<bool> &visited)
{
    visited[u] = true;
    
    for(auto v: adj[u])
    {
        if(visited[v] == false)
        {
            DFSRec(adj, v, st, visited);
        }
    }
    
    st.push(u);
}

string topologicalSort(vector<int> adj[], int V)
{
    stack<int> st;
    vector<bool> visited(V, false);
    
    for(int v=0; v < V; v++)
    {
        if(adj[v].size())
        {
            for(auto u: adj[v])
            {
                if(visited[u] == false)
                {
                    DFSRec(adj, u, st, visited);
                }
            }
        }
    }
    
    string res;
    while(st.empty() == false)
    {
        res += st.top() + 'a';;
        
        st.pop();
    }
    
    return res;
}

string findOrder(string words[], int N, int K) 
{
    vector<int> adj[K];
    
    for(int i = 0; i < N-1; i++)
    {
        string word1 = words[i];
        string word2 = words[i+1];
        
        for(int j = 0; j < min(word1.size(), word2.size()); j++)
        {
            if(word1[j] != word2[j])
            {
                int index1 = word1[j] - 'a';
                int index2 = word2[j] - 'a';
                
                adj[index1].push_back(index2);
                
                break;
            }
        }
    }
    
    return topologicalSort(adj, K);
    }
};