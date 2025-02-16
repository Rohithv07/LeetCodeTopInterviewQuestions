import java.util.*;

public class PrintSubsequenceSumEqualsK {
    public static void main(String [] args) {
        int [] arr = new int []{1, 2, 1};
        int sum = 2;
        List<Integer> result = new ArrayList<>();
        findSubsequenceSumEqualsK(0, 0, result, arr, sum);
    }

    private static void findSubsequenceSumEqualsK(int index, int currentSum, List<Integer> result, int [] arr, int k) {
        if (currentSum == k) {
            for (Integer num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        if (index >= arr.length) {
            return;
        }
        // pick
        currentSum += arr[index];
        result.add(arr[index]);
        findSubsequenceSumEqualsK(index + 1, currentSum, result, arr, k);
        // not pick
        currentSum -= arr[index];
        result.remove(result.size() - 1);
        findSubsequenceSumEqualsK(index + 1, currentSum, result, arr, k);
    }
}
