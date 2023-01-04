Given an array of strings arr[]. You have to find the longest string which is lexicographically smallest and also all of its prefix strings are already present in the array.

 

Example 1:

Input: ab a abc abd
Output: abc
Explanation: We can see that length of the longest 
string is 3. And there are two string "abc" and "abd"
of length 3. But for string "abc" , all of its prefix
"a" "ab" "abc" are present in the array. So the
output is "abc".
Example 2:

Input: ab a aa abd abc abda abdd abde abdab
Output: abdab
Explanation: We can see that each string is fulfilling
the condition. For each string, all of its prefix 
are present in the array.And "abdab" is the longest
string among them. So the ouput is "abdab".
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function longestString() which takes the array arr[] as input parameter and returns the longest string which is also lexicographically smallest.And if there is no such string return empty string.
 

Expected Time Complexity: O(NlogN)
Expected Space Complexity: O(N)

 

Constraints:
1 <= length of arr[] <= 103
1 <= arr[i].length <=30




class Solution {
    private static TrieNode root;
    public Solution() {
        this.root = new TrieNode();
    }
    public static String longestString(int n, String[] arr) {
        // code here
        if (arr == null || n == 0) {
            return "";
        }
        String largest = "";
        for (String s : arr) {
            insert(s);
        }
        for (String s : arr) {
            if (isPresent(s)) {
                if (largest == "" || largest.length() == 0) {
                    largest = s;
                    continue;
                }
                if (s.length() > largest.length()) {
                    largest = s;
                }
                else if (s.length() == largest.length()) {
                    if (s.compareTo(largest) < 0) {
                        largest = s;
                    }
                    else {
                        continue;
                    }
                }
            }
        }
        return largest;
    }
    private static void insert(String s) {
        TrieNode node = root;
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            if (node.count[index] == null) {
                node.count[index] = new TrieNode(false);
            }
            node = node.count[index];
        }
        node.isEnd = true;
    }
        
    private static boolean isPresent(String s) {
        TrieNode node = root;
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            if (!node.count[index].isEnd) {
                return false;
            }
            node = node.count[index];
        }
        return node.isEnd;
    }
}

class TrieNode {
    boolean isEnd;
    TrieNode []count = new TrieNode[26];
    
    public TrieNode() {
    }
    public TrieNode(boolean isEnd) {
        this.isEnd = false;
    }
}
        
