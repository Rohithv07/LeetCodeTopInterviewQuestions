import java.util.*;

public class DistinctNumbers {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int [n];
        for (int index = 0; index < n; index++) {
            nums[index] = sc.nextInt();
        }
        System.out.println(findDistinctNumbers(nums));
    }

    public static int findDistinctNumbers(int [] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int index = 0; index < nums.length; index++) {
            if (index == 0 || nums[index] != nums[index - 1]) {
                count++;
            }
        }
        return count;
    }
}