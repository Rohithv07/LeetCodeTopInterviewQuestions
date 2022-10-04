Geek has a list Li containing (not necessarily distinct) N words and Q queries. Each query consists of a string x. For each query, find how many strings in the List Li has the string x as its prefix. 


Example 1:

Input: 
N = 5, Q = 5
li[] = {'abracadabra', 'geeksforgeeks', 
      'abracadabra', 'geeks', 'geeksthrill'}
query[] = {'abr', 'geeks', 'geeksforgeeks', 
         'ge', 'gar'}

Output: 2 3 1 3 0

Explaination: 
Query 1: The string 'abr' is prefix of 
two 'abracadabra'. 
Query 2: The string 'geeks' is prefix of three 
strings 'geeksforgeeks', 'geeks' and 'geeksthrill'. 
Query 3: The string 'geeksforgeeks' is prefix 
of itself present in li. 
Query 4: The string 'ge' also is prefix of three 
strings 'geeksforgeeeks', 'geeks', 'geeksthrill'. 
Query 5: The string 'gar' is not a prefix of any 
string in li.

Your Task:
You do not need to read input or print anything. Your task is to complete the function prefixCount() which takes N, Q, li[] and query[] as input parameters and returns a list containing the count of prefixes for each query. 


Expected Time Complexity: O(Q*x)
Expected Auxiliary Space: O(N*li [i])


Constraints:
1 ≤ N ≤ 3 x 104
1 ≤ Q ≤ 104
1 ≤ |li[i]|, |x| ≤ 100  


class Solution{
    
    private static TrieNode root;
    
    public Solution() {
        this.root = new TrieNode();
    }
    
    static List<Integer> prefixCount(int n, int q, String li[], String query[])
    {
        // code here
        List<Integer> result = new ArrayList<>();
        for (String s : li) {
            insert(s);
        } 
        for (String s : query) {
            int searchCount = search(s);
            result.add(searchCount);
        }
        return result;
    }
    
    private static void insert(String s) {
        TrieNode node = root;
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
                node.ch = ch;
            }
            node = node.children[index];
            node.count++;
        }
    }
    
    
    private static int search(String s) {
        TrieNode node = root;
        int count = 0;
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return 0;
            }
            node = node.children[index];
        }
        return node.count;
    }
}

class TrieNode {
    char ch;
    int count;
    TrieNode [] children;
    
    public TrieNode() {
        this.ch = ch;
        this.count = 0;
        this.children = new TrieNode[26];
    }
}