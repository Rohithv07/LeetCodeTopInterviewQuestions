Geek is at the geek summer carnival. He is given an array of N strings. To unlock exclusive course discounts he needs to find the longest common prefix among all strings present in the array. Can you help him ?


Example 1:

Input:
N = 4
ar[] = {geeksforgeeks, geeks, geek, geezer}

Output:
gee

Explanation: 
Longest common prefix in all the given string is gee. 
 

Example 2:

Input:
N = 3
ar[] = {apple, ape, april}

Output:
ap

Your Task:
You don't need to read input or print anything. Complete the function LCP() that takes integer n and ar[] as input parameters and return the LCP. 

 

Expected time complexity: O(NlogN)
Expected space complexity: O(string length)


Constraints:
1 <= N <= 10^3
1 <= String Length <= 100

class Solution
{
    public String lcp(String s[],int n)
    {
        // Write your code here
        if (n == 1) {
            return s[0];
        }
        Arrays.sort(s);
        String smallestString = s[0];
        String largestString = s[n - 1];
        int smallestStringLength = smallestString.length();
        int largestStringLength = largestString.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < smallestStringLength) {
            if (smallestString.charAt(i) != largestString.charAt(j)) {
                break;
            }
            sb.append(smallestString.charAt(i));
            i++;
            j++;
        }
        String resultString = sb.toString();
        return resultString.length() == 0 ? "-1" : resultString;
    }
}
