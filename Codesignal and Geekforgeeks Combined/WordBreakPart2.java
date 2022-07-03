Given a string s and a dictionary of words dict of length n, add spaces in s to construct a sentence where each word is a valid dictionary word. Each dictionary word can be used more than once. Return all such possible sentences.

Follow examples for better understanding.

Example 1:

Input: s = "catsanddog", n = 5 
dict = {"cats", "cat", "and", "sand", "dog"}
Output: (cats and dog)(cat sand dog)
Explanation: All the words in the given 
sentences are present in the dictionary.
Example 2:

Input: s = "catsandog", n = 5
dict = {"cats", "cat", "and", "sand", "dog"}
Output: Empty
Explanation: There is no possible breaking 
of the string s where all the words are present 
in dict.
Your Task:
You do not need to read input or print anything. Your task is to complete the function wordBreak() which takes n, dict and s as input parameters and returns a list of possible sentences. If no sentence is possible it returns an empty list.

Expected Time Complexity: O(N2*n) where N = |s|
Expected Auxiliary Space: O(N2)

Constraints:
1 ≤ n ≤ 20
1 ≤ dict[i] ≤ 15
1 ≤ |s| ≤ 500 



class Solution{
    static void solver(List<String> dict, String s, String temp, List<String> solution){
        if(s.length()==0){
            solution.add(temp.substring(0,temp.length()-1));
        }
        for(int i=0; i<s.length(); i++){
            String left = s.substring(0,i+1);
            if(dict.contains(left)){
                String right = s.substring(i+1);
                solver(dict, right, temp + left + " ", solution);
            }
        }
    }
    static List<String> wordBreak(int n, List<String> dict, String s)
    {
        List<String> solution = new ArrayList<>();
        solver(dict, s, "", solution);
        return solution;
    }
}