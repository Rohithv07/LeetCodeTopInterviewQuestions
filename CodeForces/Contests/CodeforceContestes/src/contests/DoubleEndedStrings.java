package contests;

import java.util.Arrays;
import java.util.Scanner;

public class DoubleEndedStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(findMinimumNumberOfOperation(s1, s2));
        }
        sc.close();
    }

    private static int findMinimumNumberOfOperation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][][][] dp = new int[n][m][n][m];
        for (int[][][] d1 : dp) {
            for (int[][] d2 : d1) {
                for (int[] d3 : d2) {
                    Arrays.fill(d3, -1);
                }
            }
        }

        int maxCommon = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                maxCommon = Math.max(maxCommon, longestCommonSubstring(s1, s2, i, j, s1.length() - 1, s2.length() - 1, dp));
            }
        }

        return s1.length() + s2.length() - 2 * maxCommon;
    }

    private static int longestCommonSubstring(String a, String b, int i, int j, int k, int l, int[][][][] dp) {
        if (i > k || j > l) {
            return 0;
        }

        if (dp[i][j][k][l] != -1) {
            return dp[i][j][k][l];
        }

        int maxLen = 0;
        for (int x = i; x <= k; x++) {
            for (int y = j; y <= l; y++) {
                int len = 0;
                while (x + len <= k && y + len <= l && a.charAt(x + len) == b.charAt(y + len)) {
                    len++;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return dp[i][j][k][l] = maxLen;
    }
}