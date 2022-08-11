Given a string S consisting of uppercase and lowercase characters. The task is to sort uppercase and lowercase letters separately such that if the ith place in the original string had an Uppercase character then it should not have a lowercase character after being sorted and vice versa.

Example 1:

Input:
N = 12
S = defRTSersUXI
Output: deeIRSfrsTUX
Explanation: Sorted form of given string
with the same case of character as that
in original string is deeIRSfrsTUX
Example 2:

Input:
N = 6
S = srbDKi
Output: birDKs
Explanation: Sorted form of given string
with the same case of character will
result in output as birDKs.
Your Task:
You only need to complete the function caseSort that takes a string str and length of the string n and returns sorted string.

Expected Time Complexity: O(Nlog(N)).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 105



class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
        // Your code here
        List<Character> lower = new ArrayList<>();
        List<Character> upper = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            if (ch <= 'Z') {
                upper.add(ch);
            }
            else {
                lower.add(ch);
            }
        }
        Collections.sort(lower);
        Collections.sort(upper);
        int forLower = 0;
        int forUpper = 0;
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch <= 'Z') {
                char upperLetter = upper.get(forUpper);
                result.append(upperLetter);
                forUpper++;
            }
            else {
                char lowerLetter = lower.get(forLower);
                result.append(lowerLetter);
                forLower++;
            }
        }
        return result.toString();
    }
}