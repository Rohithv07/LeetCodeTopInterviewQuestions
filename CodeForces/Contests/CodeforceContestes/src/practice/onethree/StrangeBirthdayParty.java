/**
 * @author rohithvazhathody
 * @date 18 Apr 2026
 * Project: CodeforceContestes
 * File: StrangeBirthdayParty.java
 */

package practice.onethree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StrangeBirthdayParty {

    public static void main(String[] args) throws IOException {
        // Use a FastScanner instead of java.util.Scanner
        FastScanner sc = new FastScanner();
        
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            // Changed to int[] to avoid casting overhead later
            int[] nums = new int[n];
            for (int index = 0; index < n; index++) {
                nums[index] = sc.nextInt();
            }
            
            int[] gift = new int[m];
            for (int index = 0; index < m; index++) {
                gift[index] = sc.nextInt();
            }
            
            long minCost = findMinCost(nums, gift);
            System.out.println(minCost);
        }
    }

    private static long findMinCost(int[] nums, int[] gift) {
        Arrays.sort(nums);
        long result = 0;
        int cheapest = 0;
        
        for (int index = nums.length - 1; index >= 0; index--) {
            // Casting is no longer needed here
            if (cheapest < gift.length && gift[cheapest] <= gift[nums[index] - 1]) {
                result += gift[cheapest];
                cheapest++;
            } else {
                result += gift[nums[index] - 1];
            }
        }
        return result;
    }

    // Standard Fast I/O class for competitive programming
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}


/*
 * 2 3 4 3 2
 * 
 * 3 5 12 20
 * 
 * 8 20
 * 
 * 
 * 2 5 9 12 14
 * 
 * 3 8 20 40
 * 
 * 2+3+4
 * 
 * 5 + 8 + 4 + 2
 * 
 * 2
 * 20
 * 
 * 5 + 12
 * 
 * 2 3 3 4
 * 
 * 3 20
 * 
 * 1 4
 * 
 * 
 */
