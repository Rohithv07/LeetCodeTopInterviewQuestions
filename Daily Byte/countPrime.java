import java.util.*;

public class Solution {
    public static int countPrime(int n) {
        // create a boolean array
        // O(nlog(logn))
        boolean [] prime = new boolean [n];
        for (int i=2; i*i < n; i++) {
            if (!prime[i]) {
                for (int j=2; j*i<n; j++) {
                    prime[j*i] = true;
                }
            }
        }
        int countPrimeNumber = 0;
        for (int i=2; i<n; i++) {
            if (!prime[i])
                countPrimeNumber += 1;
        }
        return countPrimeNumber;
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(countPrime(number));
    }
}