You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.

Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.

 

Example 1:

Input: equations = ["a==b","b!=a"]
Output: false
Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
There is no way to assign the variables to satisfy both equations.
Example 2:

Input: equations = ["b==a","a==b"]
Output: true
Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 

Constraints:

1 <= equations.length <= 500
equations[i].length == 4
equations[i][0] is a lowercase letter.
equations[i][1] is either '=' or '!'.
equations[i][2] is '='.
equations[i][3] is a lowercase letter.


class Solution {
    public boolean equationsPossible(String[] equations) {
        int length = 26;
        UnionFind uf = new UnionFind(length);
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                uf.union(s.charAt(0), s.charAt(3));
            }
        }
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                if (uf.find(s.charAt(0) - 'a') == uf.find(s.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
}

class UnionFind {
    int size;
    int component;
    int [] parent;
    int [] rank;
    
    public UnionFind(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N cannot be negative or zero");
        }
        size = n;
        component = n;
        parent = new int [n];
        rank = new int [n];
        for (int i = 0; i < n; i++) {
            rank[i] = i;
        }
    }
    
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    
    public void union(char ch1, char ch2) {
        int root1 = find(ch1 - 'a');
        int root2 = find(ch2 - 'a');
        if (root1 == root2) {
            return;
        }
        if (rank[root2 - 'a'] > rank[root1 - 'a']) {
            parent[root1 - 'a'] = root2;
        }
        else {
            parent[root2] = root1;
            if (parent[root1 - 'a'] == parent[root2 - 'a']) {
                rank[root1 - 'a']++;
            }
        }
        component--;
    }
}