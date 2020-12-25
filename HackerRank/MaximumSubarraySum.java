https://www.hackerrank.com/challenges/maximum-subarray-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search






import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {
        long maximumSum = 0;
        long currentSum = 0;
        int n = a.length;
        TreeSet<Long> prefix = new TreeSet<>();
        // compute the prefix sum
        for (int i=0; i<n; i++) {
            currentSum = (currentSum + a[i] % m) % m;
            maximumSum = Math.max(currentSum, maximumSum);
            // checks for any number which is strictly greater than the currentSum.
            Long pre = prefix.higher(currentSum);
            if (pre != null) {
                maximumSum = Math.max(maximumSum, (currentSum - pre + m) % m);
            }
            prefix.add(currentSum);
        }
        return maximumSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

