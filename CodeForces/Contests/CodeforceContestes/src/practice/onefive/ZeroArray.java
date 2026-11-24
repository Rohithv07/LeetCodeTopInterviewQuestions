/**
 * @author rohithvazhathody
 * @date 9 Nov 2026
 * Project: CodeforceContestes
 * File: ZeroArray.java
 */

package practice.onefive;

/**
 * 
 */
import java.io.*;
import java.util.*;

public class ZeroArray {

    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int test = 1;
        while (test-- > 0) {
            // odd not working
            int n = fastReader.nextInt();
            long [] nums = new long [n];
            for (int index = 0; index < n; index++) {
                nums[index] = fastReader.nextLong();
            }
            String possible = findIfPossible(nums);
            out.println(possible);
        }
        out.flush();
        out.close();
    }

    private static String findIfPossible(long[] nums) {
        long totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 == 1) {
            return "NO";
        }
        Arrays.sort(nums);
        long remainingSum = totalSum - nums[nums.length - 1];
        return remainingSum >= nums[nums.length - 1] ? "YES" : "NO";
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            try {
                 while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
