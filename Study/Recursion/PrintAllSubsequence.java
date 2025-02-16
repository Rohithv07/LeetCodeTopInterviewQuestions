import java.util.*;
public class PrintAllSubsequence {
    public static void main(String [] args) {
        int [] arr = new int []{3, 1, 2};
        List<Integer> result = new ArrayList<>();
        findSubsequenceOfArray(0, arr, result);
    }

    private static void findSubsequenceOfArray(int index, int [] arr, List<Integer> result) {
        if (index >= arr.length) {
            for (Integer num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        result.add(arr[index]);
        findSubsequenceOfArray(index + 1, arr, result);
        result.remove(result.size() - 1);
        findSubsequenceOfArray(index + 1, arr, result);
    }
}
