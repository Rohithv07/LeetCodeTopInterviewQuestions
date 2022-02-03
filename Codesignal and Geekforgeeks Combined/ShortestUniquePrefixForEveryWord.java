Given an array of words, find all shortest unique prefixes to represent each word in the given array. Assume that no word is prefix of another.

Example 1:

Input: 
N = 4
arr[] = {"zebra", "dog", "duck", "dove"}
Output: z dog du dov
Explanation: 
z => zebra 
dog => dog 
duck => du 
dove => dov 
Example 2:

Input: 
N = 3
arr[] =  {"geeksgeeks", "geeksquiz",
                       "geeksforgeeks"};
Output: geeksg geeksq geeksf
Explanation: 
geeksgeeks => geeksg 
geeksquiz => geeksq 
geeksforgeeks => geeksf
Your task:
You don't have to read input or print anything. Your task is to complete the function findPrefixes() which takes the array of strings and it's size N as input and returns a list of shortest unique prefix for each word
 
Expected Time Complexity: O(N*length of each word)
Expected Auxiliary Space: O(N*length of each word)
 
Constraints:
1 ≤ N, Length of each word ≤ 1000








public static class Trie {
int[] count = new int[26];
Trie[] next;
}

static String[] findPrefixes(String[] arr, int N) {
Trie[] head = new Trie[26];
for (int i = 0; i < 26; i++) {
head[i] = new Trie();
}

// filling
for (int i = 0; i < N; i++) {
char[] ch = arr[i].toCharArray();
Trie temp = head[ch[0] - 97];
for (int j = 0; j < ch.length; j++) {
temp.count[ch[j] - 97] = temp.count[ch[j] - 97] + 1;
if (j != ch.length - 1) {
if (temp.next == null) {
temp.next = new Trie[26];
}
if (temp.next[ch[j + 1] - 97] == null) {
temp.next[ch[j + 1] - 97] = new Trie();
}
temp = temp.next[ch[j + 1] - 97];
}
}
}

String[] result = new String[N];

// checking
for (int i = 0; i < N; i++) {
char[] ch = arr[i].toCharArray();
Trie temp = head[ch[0] - 97];
for (int j = 0; j < ch.length; j++) {
if (temp.count[ch[j] - 97] == 1) {
result[i] = arr[i].substring(0, j + 1);
break;
}
if (j != ch.length - 1) {
temp = temp.next[ch[j + 1] - 97];
}
}
}

return result;
}