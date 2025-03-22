/*
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 

Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.


hors

ro

* expressing in terms of index

* try all possibility

* find the min or max based on requirement

f(0, 2)

s1[0..0] and s2[0... 2]

f(i1, i2, s1, s2) {

    i1 => 0 i2 + 1

    i2 => 0 i1 + 1

    charaters equal
    f(i1 - 1, i2 - 1, s1, s2)

     characters not equal :
     insert => f(i1, i2 - 1, s1, s2)
     delete => f(i1-1, i2, s1, s1)
     replace => (f(i1 - 1, i2 - 1, s1, s2))

}

*/


import java.util.*;

public class EditDistance {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String source = sc.next();
        String target = sc.next();
        System.out.println(findMinimumUsingMemo(source, target));
        System.out.println(findMinimumUsingTabulation(source, target));
        System.out.println(findMinimumUsingTabulationSpaceOp(source, target));
        sc.close();
    }


    private static int findMinimumUsingTabulationSpaceOp(String source, String target) {
        if (source.equals(target)) {
            return 0;
        }
        int length1 = source.length();
        int length2 = target.length();
        int [] previous = new int [length2 + 1];
        int [] current = new int [length2 + 1];
        for (int index2 = 1; index2 <= length2; index2++) {
            previous[index2] = index2;
        }
        for (int index1 = 1; index1 <= length1; index1++) {
            current[0] = index1;
            for (int index2 = 1; index2 <= length2; index2++) {
                if (source.charAt(index1 - 1) == target.charAt(index2 - 1)) {
                   current[index2] = previous[index2 - 1];
                }
                else {
                    int insert = current[index2 - 1];
                    int delete = previous[index2];
                    int replace = previous[index2 - 1];
                    current[index2] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
            int [] temp = previous;
            previous = current;
            current = temp;
        }
        return previous[length2];
    }

    private static int findMinimumUsingTabulation(String source, String target) {
        if (source.equals(target)) {
            return 0;
        }
        int length1 = source.length();
        int length2 = target.length();
        int [][] dp = new int [length1 + 1][length2 + 1];
        for (int index2 = 1; index2 <= length2; index2++) {
            dp[0][index2] = index2 + 1;
        }
        for (int index1 = 1; index1 <= length1; index1++) {
            dp[index1][0] = index1 + 1;
        }
        for (int index1 = 1; index1 <= length1; index1++) {
            for (int index2 = 1; index2 <= length2; index2++) {
                if (source.charAt(index1 - 1) == target.charAt(index2 - 1)) {
                    dp[index1][index2] = dp[index1 - 1][index2 - 1];
                }
                else {
                    int insert = dp[index1][index2 - 1];
                    int delete = dp[index1 - 1][index2];
                    int replace = dp[index1 - 1][index2 - 1];
                    dp[index1][index2] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[length1][length2];
    }

    private static int findMinimumUsingMemo(String source, String target) {
        if (source.equals(target)) {
            return 0;
        }
        int sourceLength = source.length();
        int targetLength = target.length();
        int [][] dp = new int [sourceLength][targetLength];
        for (int [] d : dp) {
            Arrays.fill(d, -1);
        }
        return findMinOp(source, target, sourceLength - 1, targetLength - 1, dp);
        //return dp[sourceLength - 1][targetLength - 1];
    }

    private static int findMinOp(String source, String target, int index1, int index2, int [][] dp) {
        if (index1 < 0) {
            return index2 + 1;
        }
        if (index2 < 0) {
            return index1 + 1;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }
        if (source.charAt(index1) == target.charAt(index2)) {
            return dp[index1][index2] = findMinOp(source, target, index1 - 1, index2 - 1, dp);
        }
        int insert = findMinOp(source, target, index1, index2 - 1, dp);
        int delete = findMinOp(source, target, index1 - 1, index2, dp);
        int replace = findMinOp(source, target, index1 - 1, index2 - 1, dp);
        return dp[index1][index2] = 1 + Math.min(insert, Math.min(delete, replace));
    }
}












/*

class Solution {

    private static final int MAX = (int)(1e9);

    public int minDistance(String word1, String word2) {
        if ((word1 == null || word2 == null) || (word1.equals(word2))) {
            return 0;
        }
        int length1 = word1.length();
        int length2 = word2.length();
        int [][] dp = new int [length1 + 1][length2 + 1];
        for (int [] d : dp) {
            Arrays.fill(d, -1);
        }
        return findMinDistance(word1, word2, length1 - 1, length2 - 1, dp);
    }

    private int findMinDistance(String s1, String s2, int index1, int index2, int [][] dp) {
        if (index1 < 0) {
            return index2 + 1;
        }
        if (index2 < 0) {
            return index1 + 1;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }
        if (s1.charAt(index1) == s2.charAt(index2)) {
            return dp[index1][index2] = findMinDistance(s1, s2, index1 - 1, index2 - 1, dp);
        }
        // else we have insert, delete or replace
       int insert = findMinDistance(s1, s2, index1, index2 - 1, dp);
       int delete = findMinDistance(s1, s2, index1 - 1, index2, dp);
       int replace = findMinDistance(s1, s2, index1 - 1, index2 - 1, dp);
       return dp[index1][index2] = 1 + Math.min(insert, Math.min(delete, replace));
    }
}
 */


 