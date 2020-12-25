https://www.hackerrank.com/challenges/minimum-time-required/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        long max = Arrays.stream(machines).max().getAsLong();
        long min = Arrays.stream(machines).min().getAsLong();
        long minimumDays = 0;
        long maximumDays = max * goal;
        long result = -1;
        while (minimumDays < maximumDays) {
            long middle = minimumDays + (maximumDays - minimumDays) / 2;
            long unit = totalUnitOfWork(machines, middle);
            if (unit < goal) {
                minimumDays = middle + 1;
            }
            else {
                maximumDays = middle;
                result = middle;
            }
        }
        return result;

    }
    
    static long totalUnitOfWork(long [] machines, long mid) {
        long total = 0;
        for (long machine : machines)
            total = total + (mid / machine);
        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

