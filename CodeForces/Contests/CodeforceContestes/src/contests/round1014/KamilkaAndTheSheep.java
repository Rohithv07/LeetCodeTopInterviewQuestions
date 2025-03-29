import java.util.*;
/**
 * @author rohithvazhathody
 * @date 2025-03-29
 */
public class KamilkaAndTheSheep {
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
        sc.close();
    }

    private static int maxBeauty(int[] nums, int n) {
        Arrays.sort(nums);
        return nums[n - 1] - nums[0];
    }
}