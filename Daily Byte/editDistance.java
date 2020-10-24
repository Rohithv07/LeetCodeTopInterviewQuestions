This question is asked by Google. Given two strings s and t, return the minimum number of operations needed to convert s into t where a single operation consists of inserting a character, deleting a character, or replacing a character.

Ex: Given the following strings s and t…

s = "cat", t = "bat", return 1.

Ex: Given the following strings s and t…

s = "beach", t = "batch", return 2.
Delete the 'e' in "beach" and add a 't' to the resulting "bach".


// so if we have two strings, we are provided by 3 possible operations 1)insert 2)delete 3)replcae
// we need to convert s1 to s2 with the minimum operations
/*

Let following be the function definition :-

f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2

Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.

f(i, j) = f(i - 1, j - 1)

Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper

f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }

f(i, j - 1) represents insert operation
f(i - 1, j) represents delete operation
f(i - 1, j - 1) represents replace operation
Here, we consider any operation from word1 to word2. It means, when we say insert operation, we insert a new character after word1 that matches the jth character of word2. So, now have to match i characters of word1 to j - 1 characters of word2. Same goes for other 2 operations as well.

Note that the problem is symmetric. The insert operation in one direction (i.e. from word1 to word2) is same as delete operation in other. So, we could choose any direction.
*/

public int minDistance(String word1, String word2) {
	 // we create a dp array
        int length1 = word1.length();
        int length2 = word2.length();
        int [][] dp = new int [length1+1][length2+1];
        for (int i=0; i<=length1; i++) {
            for (int j=0; j<=length2; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
            }
        }
        return dp[length1][length2];
}

O(length1 * length2)
