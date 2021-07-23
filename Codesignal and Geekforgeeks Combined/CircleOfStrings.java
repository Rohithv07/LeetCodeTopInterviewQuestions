Given an array of lowercase strings A[] of size N, determine if the strings can be chained together to form a circle.
A string X can be chained together with another string Y if the last character of X is same as first
character of Y. If every string of the array can be chained, it will form a circle.

For example, for the array arr[] = {"for", "geek", "rig", "kaf"} the answer will be Yes as the given strings can be chained as "for", "rig", "geek" and "kaf"


Example 1:

Input:
N = 3
A[] = { "abc", "bcd", "cdf" }
Output:
0
Explaination:
These strings can't form a circle 
because no string has 'd'at the starting index.
Example 2:

Input:
N = 4
A[] = { "ab" , "bc", "cd", "da" }
Output:
1
Explaination:
These strings can form a circle 
of strings.

Your Task:
You don't need to read input or print output. Your task is to complete the function isCircle() which takes the length of the array N and the array A as input parameters and returns 1 if we can form a circle or 0 if we cannot.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints: 
1 ≤ N ≤ 104
1 ≤ Length of strings ≤ 20



// https://leetcode.com/discuss/general-discussion/1297783/Circle-of-strings-oror-GRAPHS-oror-MICROSOFT-oror-EASY-oror-C%2B%2B
class Solution
{
    static int isCircle(int n, String s[])
    {
        // code here
        if (s == null || s.length == 0) {
            return 0;
        }
        int [] indegree = new int [26];
        int [] outdegree = new int [26];
        Map<Character, List<Character>> graph = new HashMap<>();
        for (String current : s) {
            if (!graph.containsKey(current.charAt(0))) {
                graph.put(current.charAt(0), new ArrayList<>());
            }
            graph.get(current.charAt(0)).add(current.charAt(current.length() - 1));
            outdegree[current.charAt(0) - 'a'] += 1;
            indegree[current.charAt(current.length() - 1) - 'a'] += 1; 
        }
        for (int i=0; i<26; i++) {
            if (indegree[i] != outdegree[i])
                return 0;
        }
        Set<Character> visited = new HashSet<>();
        if (!dfs(s[0].charAt(0), visited, graph))
            return 0;
        return 1;
    }
    
    static boolean dfs(char currentNode, Set<Character> visited, Map<Character, List<Character>> graph) {
        if (visited.contains(currentNode)) {
            return visited.size() == graph.size();
        }
        visited.add(currentNode);
        for (char child : graph.get(currentNode)) {
            if (dfs(child, visited, graph))
                return true;
        }
        return false;
    }
}

