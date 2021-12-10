Given a string S find all possible subsequences of the string in lexicographically-sorted order.

Example 1:

Input : str = "abc"
Output: a ab abc ac b bc c
Explanation : There are 7 substrings that 
can be formed from abc.
Example 2:

Input: str = "aa"
Output: a a aa
Explanation : There are 3 substrings that 
can be formed from aa.
Your Task:
You don't need to read ot print anything. Your task is to complete the function AllPossibleStrings() which takes S as input parameter and returns a list of all possible substrings(non-empty) that can be formed from S in lexicographically-sorted order.
 

Expected Time Complexity: O(2n) where n is the length of the string
Expected Space Complexity : O(n * 2n)
 

Constraints: 
1 <= Length of string <= 16



// ref video : https://youtu.be/b7AYbpM5YrE
class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        int length = s.length();
        int threshold = (1 << length);
        for (int num = 0; num < threshold; num++) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<length; i++) {
                // if ith bit is set, then include ith character
                if ((num & (1 << i)) != 0) {
                    sb.append(s.charAt(i));
                }
            }
            if (sb.toString().length() > 0)
                result.add(sb.toString());
        }
        Collections.sort(result);
        return result;
    }
}