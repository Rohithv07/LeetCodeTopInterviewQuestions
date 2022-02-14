Given two strings S1 and S2 in lowercase, the task is to make them anagram. The only allowed operation is to remove a character from any string. Find the minimum number of characters to be deleted to make both the strings anagram. Two strings are called anagram of each other if one of them can be converted into another by rearranging its letters.

Example 1:

Input:
S1 = bcadeh
S2 = hea
Output: 3
Explanation: We need to remove b, c
and d from S1.
Example 2:

Input:
S1 = cddgk
S2 = gcd
Output: 2
Explanation: We need to remove d and
k from S1.
Your Task:
Complete the function remAnagram() which takes two strings S1, S2 as input parameter, and returns minimum characters needs to be deleted.

Expected Time Complexity: O(max(|S1|, |S2|)), where |S| = length of string S.
Expected Auxiliary Space: O(26)

Constraints:
1 <= |S1|, |S2| <= 105


/*Complete the function below*/
class GfG
{
	public int remAnagrams(String s1,String s2)
    {
        //add code here.
        if (s1.equals(s2)) {
            return 0;
        }
        int length1 = s1.length();
        int length2 = s2.length();
        int [] frequency = new int [26];
        int countOfStringToDelete = 0;
        for (char firstStringChar : s1.toCharArray()) {
            frequency[firstStringChar - 'a'] += 1;
        }
        for (char secondStringChar : s2.toCharArray()) {
            frequency[secondStringChar - 'a'] -= 1;
        }
        for (int freq : frequency) {
            // System.out.print(freq + " ");
            if (freq != 0) {
                countOfStringToDelete += Math.abs(freq);
            }
        }
        return countOfStringToDelete;
    }
}