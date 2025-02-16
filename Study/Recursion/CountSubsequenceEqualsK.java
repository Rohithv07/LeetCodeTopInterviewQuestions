import java.util.*;

public class CountSubsequenceEqualsK {
    public static void main(String[] args) {
        int [] arr = new int []{1, 2, 3};
        int target = 3;
        System.out.println(countSubsequence(0, 0, arr, target));
    }

    private static int countSubsequence(int index, int currentSum, int [] arr, int target) {
        if (index > arr.length) {
            return 0;
        }
        if (index == arr.length) {
            if (currentSum == target) {
                return 1;
            }
            return 0;
        }
        // pick
        currentSum += arr[index];
        int countPick = countSubsequence( index + 1, currentSum, arr, target);
        // not pick
        currentSum -= arr[index];
        int countNotPick = countSubsequence(index + 1, currentSum, arr, target);
        return countPick + countNotPick;
    }
}
