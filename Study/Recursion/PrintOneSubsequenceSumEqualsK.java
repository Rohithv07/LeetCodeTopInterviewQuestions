import java.util.*;

public class PrintOneSubsequenceSumEqualsK {
    public static void main(String[] args) {
        int [] arr = new int []{1, 2, 1};
        int sum = 2;
        List<Integer> result = new ArrayList<>();
        findSubsequence(0, 0, result, arr, sum);
    }

    private static boolean findSubsequence(int index, int currentSum, List<Integer> result, int [] arr, int sum) {
        if (index == arr.length) {
            if (currentSum == sum) {
                for (Integer num : result) {
                    System.out.print(num + " ");
                }
                System.out.println();
                return true;
            }
            return false;
        }
        // pick
        currentSum += arr[index];
        result.add(arr[index]);
        if (findSubsequence(index + 1, currentSum, result, arr, sum)) {
            return true;
        }
        currentSum -= arr[index];
        result.remove(result.size() - 1);
        if (findSubsequence(index + 1, currentSum, result, arr, sum)) {
            return true;
        }
        return false;
    }
}
