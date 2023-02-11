// https://practice.geeksforgeeks.org/contest/interview-series-63/problems/#

// https://www.youtube.com/watch?v=zg43_5GU03w




/*
1. find the count of consecutive equals elements present in the given string.
2. Traverse through the string and check whether the consecutive count is already 0.
If thats the case, we can already return the days as there are no consecutive elements prsent.
3. Else we need to check if a[i - 1] == a[i] && a[i] == a[i + 1] cases.
aaa -> here the consective count is aa and aa => 2
So when the condition meets, we can decrease the consecutive count by 2 when
we are putting ? on the first index and it becomes a?a.
4. Continue this process till fully traversing or getting the count as 0.


*/


Given a string S of length N containing only lowercase alphabets. You are also given a permutation P of length N containing integers from 0 to N-1. In (i+1)'th day you can take the P[i] value of the permutation array and replace S[P[i]] with a '?'.

For example in day 1, we can choose index of permutation array is i=0 and replace S[P[0]] with '?'.
Similarly in day 2, we can choose index of permutation array is i=1. You can replace S[P[1]] with '?'.
Similarly in day 3,we can choose index of permutation array is i=2. You can replace S[P[2]] with '?'.

You have to tell the minimum number of days required, such that after it for all index i (0<=i<N-1), if S[i]!='?', then S[i]!=S[i+1].

Example 1:

Input:
N = 4
S = "aabb"
P[] = {2, 1, 3, 0}
Output: 2
Explanation: In day 1, we replace S[P[0]] with '?'. 
After that String S = "aa?b". As we can see S 
still has character 'a' at index 0 and 1.
In day 2, we replace S[P[1]] with '?'. After 
that String S = "a??b". As we can see the String 
has for all index i (0<=i<N-1), if S[i]!='?', then S[i]!=S[i+1].
Example 2:

Input:
N = 4
S = "abca"
P[] = {3, 0, 2, 1}
Output: 0
Explanation: We can see that the initial string 
S = "abca" has for all index i (0<=i<N-1), if S[i]!='?', then S[i]!=S[i+1].
Your Task: 
You don't need to read input or print anything. Your task is to complete the function getMinimumDays() which takes the string S, array P[] and its size N as input parameters and returns the minimum number of days required such that string satisfies with the condition given earlier.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:

1 <= N <= 105
0 <= P[i] <= N-1
S contains only lowercase alphabets.

class Solution {
    public static int getMinimumDays(int n, String s, int[] p) {
        // code here
        if (n == 1) {
            return 0;
        }
        int minDays = 0;
        char [] letters = s.toCharArray();
        int countOfEqualConsecutive = findCount(s, n);
        //System.out.println(countOfEqualConsecutive);
        for (int i = 0; i < p.length; i++) {
            int index = p[i];
            if (countOfEqualConsecutive <= 0) {
                return minDays;
            }
            //  if (letters[index] == '?') {
            //     continue;
            // }
            minDays++;
            if (index == 0) {
                if (letters[index] == letters[index + 1]) {
                    countOfEqualConsecutive--;
                }
                letters[index] = '?';
            }
            else if (index == n - 1) {
                if (letters[index - 1] == letters[index]) {
                    countOfEqualConsecutive--;
                }
                letters[index] = '?';
            }
            else {
                if (letters[index - 1] == letters[index] && letters[index] == letters[index + 1]) {
                    countOfEqualConsecutive -= 2;
                }
                else if (letters[index - 1] == letters[index]) {
                    countOfEqualConsecutive--;
                }
                else if (letters[index] == letters[index + 1]) {
                    countOfEqualConsecutive--;
                }
                letters[index] = '?';
            }
        }
        return minDays;
    }
    
    private static int findCount(String s, int n) {
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }
}




class Solution {
    public static int getMinimumDays(int N, String S, int[] P) {
        // code here
        char[] c = S.toCharArray();
        int ans=0;
        for(int i=0;i<N;i++) {
            int idx = P[i];
            if(idx==0) {
                if(idx+1<N && c[idx]==c[idx+1]) {
                    c[idx]='?';
                    ans = i+1;
                }
            } else if(idx==N-1) {
                if(idx-1>=0 && c[idx]==c[idx-1]) {
                    c[idx]='?';
                    ans = i+1;
                }
            } else {
                if(c[idx]==c[idx-1] || c[idx]==c[idx+1]) {
                    c[idx]='?';
                    ans = i+1;
                }
            }
        }
        return ans;
    }
}
        

        
