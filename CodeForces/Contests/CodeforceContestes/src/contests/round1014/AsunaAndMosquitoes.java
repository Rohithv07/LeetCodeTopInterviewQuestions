package contests.round1014;

import java.util.*;
/**
 * @author rohithvazhathody
 * @date 2025-03-29
 */
public class AsunaAndMosquitoes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int [] nums = new int [n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(maxBeauty(nums, n));
                    }
                }
            
    private static long maxBeauty(int[] nums, int n) {
        int oddCount = 0;
        long sum = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                oddCount++;
            }
            sum += (long)num;
        }
        if (oddCount == n || oddCount == 0) {
            return (long)Arrays.stream(nums).max().getAsInt();
        }
        return sum - oddCount + 1;
        
    }
}