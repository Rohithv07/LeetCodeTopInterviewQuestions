/**
 * 
 */
package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class Divisors9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long sqrt = (long) Math.sqrt(n);
		boolean[] isPrime = new boolean[(int)sqrt + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i * i <= sqrt; i++) {
			if (isPrime[i]) {
				for (int j = i; j * i <= sqrt; j++) {
					isPrime[i * j] = false;
				}
			}
		}
		List<Long> primeNumberList = new ArrayList<>();
		for (long i = 2; i <= sqrt; i++) {
			if (isPrime[(int)i])
				primeNumberList.add(i);
		}
		//System.out.println(primeNumberList);
		long validCount = 0;
		// single prime number raised to 8 and 1 divisor
		// 2 prime numbers raised power 2
		//long maxP8 = (long) Math.pow(n, 1.0 / 8); 
		for (long prime : primeNumberList) {
//			if (prime > maxP8) {
//				break;
//			}
//			validCount++;
			boolean isFound = true;
			long prod = 1;
			for (int i = 0; i < 8; i++) {
				if (prod <= n) {
					prod = prod * prime;
				} else {
					isFound = false;
					break;
				}
			}
			if (isFound) {
				validCount++;
			}
		}
		for (int i = 0; i < primeNumberList.size(); i++) {
			long p1 = primeNumberList.get(i);
			long p1Square = p1 * p1;
			if (p1Square > n) {
				break;
			}
			for (int j = i + 1; j < primeNumberList.size(); j++) {
				long p2 = primeNumberList.get(j);
				long p2Square = p2 * p2;
				if (p2Square > n) {
					break;
				}
				if (p2Square * p1Square > n) {
					break;
				}
				validCount++;
			}
		}
		System.out.println(validCount);
		sc.close();
	}

}
