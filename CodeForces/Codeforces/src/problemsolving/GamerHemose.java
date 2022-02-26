/**
 * 
 */
package problemsolving;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */

public class GamerHemose {
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int t = sc.nextInt();
    while (t-- > 0) {
      solve();
    }
  }

  private static void solve() {
    int n = sc.nextInt();
    int H = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }
    Arrays.sort(arr);
    int max1 = arr[n - 1];
    int max2 = arr[n - 2];
    long sum = max1 + max2;
    long rem = H % sum;
    long q = H / sum;
    int count = 0;
    if (rem == 0) {
      System.out.println(q * 2);
      return;
    }
    count += q * 2;
    count += Math.ceil(rem / (float) max1);
    System.out.println(count);
  }
}
