Penelope and her classmates are lost in the Forbidden Forest and the Devil is out to get them. But Penelope has magical powers that can build bridges across the dangerous river and take her friends to safety. The only bridges that can withstand the Devil's wrath are the ones built between two similar trees in the forest. 
Given str1 and str2 denoting the order of trees on either side of the river, find the maximum number of bridges that Penelope can build and save everyone from the Devil. 
Note: Each tree in the forest belongs to one of the 3 categories represented by * or # or @

Example 1:

Input:
str1 = "*@#*" 
str2 = "*#"
Output:
2
Explanation:
str1 = "*@#*" and str2 = "*#" 
Two bridges can be built between the banks 
of the river in the following manner. 
* @ # *
|      |
*     #
Example 2:

Input:
str1 = "***"
str2 = "##"
Output:
0
Your Task:
You don't need to read input or print anything. Complete the function build_bridges() that takes str1 and str2 as input parameters and returns the maximum number of bridges that can be built. 

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(N*M)

Constraints:
1 ≤ N, M ≤ 100
Where, N and M are the size of the string str1 and str2 respectively.


class Sol
{
    public static int build_bridges(String str1 , String str2)
    {
       // code here 
       int length1 = str1.length();
       int length2 = str2.length();
       int [][] dp = new int [length1 + 1][length2 + 1];
       /*
       [0, 0, 0]
       [0, 0, 0]
       [0, 0, 0]
       [0. 0. 0]
       [0, 0, 0]
       */
       for (int i = 1; i <= length1; i++) {
           for (int j = 1; j <= length2; j++) {
               if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                   dp[i][j] = 1 + dp[i - 1][j - 1];
               }
               else {
                   dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
               }
           }
       }
       return dp[length1][length2];
    }
}