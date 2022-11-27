Given two binary strings A and B consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
Note: The input strings may contain leading zeros but the output string should not have any leading zeros.


Example 1:

Input:
A = "1101", B = "111"
Output: 10100
Explanation:
 1101
+ 111
10100
Example 2:

Input: 
A = "10", B = "01"
Output: 11
Explanation: 
  10
+ 01
  11

Your Task:
You don't need to read input or print anything. Your task is to complete the function addBinary() which takes 2 binary string A and B and returns a binary string denoting the addition of both the strings.


Expected Time Complexity: O(max(|A|, |B|)).
Expected Auxiliary Space: O(max(|A|, |B|)) (for output string).


Constraints:
1 ≤ |A|, |B| ≤ 106


class Solution {

    String addBinary(String A, String B) 

    {

        int i=A.length()-1;

        int j=B.length()-1;

        int carry=0;

        StringBuilder sb=new StringBuilder("");

        

        while(i>=0||j>=0||carry!=0)

        {

            int x=0;

            if(i>=0&&A.charAt(i)=='1')

            {

                x=1;

            }

            int y=0;

            if(j>=0&&B.charAt(j)=='1')

            {

                y=1;

            }

            int sum=x+y+carry;

            int val=sum%2;

            carry=sum/2;

            sb.append(val);

            i--;

            j--;

        }

        i=0;

        String res=sb.reverse().toString();

        

        for(;i<res.length();i++)

        {

            if(res.charAt(i)=='1')

            {

                break;

            }

        }

        return res.substring(i);

    }

}