import java.util.*;
public class Solution {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i=1; i<=test; i++) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            long s = sc.nextLong();
            long timeToReachK = k - 1;
            long diff = k - s;
            long remaining = n - s;
            long timeAfterExiting = k + n;
            long timeWithoutExiting = diff + timeToReachK + remaining + 1;
            long finalAnswer = Math.min(timeAfterExiting, timeWithoutExiting);
            System.out.println("Case #" + i + ": " + finalAnswer);
            
        }
    }
}
